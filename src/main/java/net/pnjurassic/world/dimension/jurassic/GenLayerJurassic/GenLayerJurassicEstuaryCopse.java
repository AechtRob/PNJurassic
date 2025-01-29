package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerJurassicEstuaryCopse extends GenLayer {


    public Biome JURASSIC_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mudflats_estuary"));
    public int JURASSIC_ESTUARY_ID =  Biome.getIdForBiome(JURASSIC_ESTUARY);
    public Biome JURASSIC_ESTUARY_FLAT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mudflats_estuary_flat"));
    public int JURASSIC_ESTUARY_FLAT_ID =  Biome.getIdForBiome(JURASSIC_ESTUARY_FLAT);
    public Biome JURASSIC_ESTUARY_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mudflats_estuary_helper"));
    public int JURASSIC_ESTUARY_HELPER_ID =  Biome.getIdForBiome(JURASSIC_ESTUARY_HELPER);

    public Biome JURASSIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean"));
    public int JURASSIC_OCEAN_ID =  Biome.getIdForBiome(JURASSIC_OCEAN);
    public Biome JURASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_shore"));
    public int JURASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(JURASSIC_OCEAN_SHORE);
    public Biome JURASSIC_OCEAN_RAFTS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_rafts"));
    public int JURASSIC_OCEAN_RAFTS_ID =  Biome.getIdForBiome(JURASSIC_OCEAN_RAFTS);
    public Biome JURASSIC_CORAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_coral"));
    public int JURASSIC_CORAL_ID =  Biome.getIdForBiome(JURASSIC_CORAL);
    public Biome JURASSIC_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_glass_sponge_reef"));
    public int JURASSIC_REEF_ID =  Biome.getIdForBiome(JURASSIC_REEF);

    public Biome JURASSIC_ESTUARY_COPSE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mudflats_estuary_copse"));
    public int JURASSIC_ESTUARY_COPSE_ID =  Biome.getIdForBiome(JURASSIC_ESTUARY_COPSE);

    private final int[] EstuaryBiomes = new int[] {
            JURASSIC_ESTUARY_FLAT_ID,
            JURASSIC_ESTUARY_COPSE_ID,
            JURASSIC_ESTUARY_COPSE_ID,
            JURASSIC_ESTUARY_COPSE_ID
    };

    public GenLayerJurassicEstuaryCopse(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    @Override
    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
        int[] aint = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaHeight; ++i)
        {
            for (int j = 0; j < areaWidth; ++j)
            {
                this.initChunkSeed(j + areaX, i + areaY);
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];
                //Biome biome = Biome.getBiome(k);

                if (!isSea(k) && !isEstuary(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isEstuary(l1)
                            || isEstuary(k2)
                            || isEstuary(j3)
                            || isEstuary(i4))
                    {
                        aint1[j + i * areaWidth] = EstuaryBiomes[nextInt(EstuaryBiomes.length)];
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else
                {
                    aint1[j + i * areaWidth] = k;
                }

            }
        }
        return aint1;
    }

    private boolean isEstuary(int biomeID) {
        return biomeID == JURASSIC_ESTUARY_ID
                || biomeID == JURASSIC_ESTUARY_FLAT_ID
                || biomeID == JURASSIC_ESTUARY_HELPER_ID;
    }

    private boolean isSea(int biomeID) {
        return biomeID == JURASSIC_OCEAN_ID || biomeID == JURASSIC_OCEAN_SHORE_ID
                || biomeID == JURASSIC_REEF_ID || biomeID == JURASSIC_OCEAN_RAFTS_ID
                || biomeID == JURASSIC_CORAL_ID;
    }

}