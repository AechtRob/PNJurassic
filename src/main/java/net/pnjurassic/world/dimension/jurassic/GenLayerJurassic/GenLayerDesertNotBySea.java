package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerDesertNotBySea extends GenLayer
{

    public Biome JURASSIC_DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_desert_rim_desert_side"));
    public int JURASSIC_DESERT_ID =  Biome.getIdForBiome(JURASSIC_DESERT);
    public Biome JURASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_shore"));
    public int JURASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(JURASSIC_OCEAN_SHORE);

    public Biome JURASSIC_FERN_PASTURE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_fern_pasture"));
    public int JURASSIC_FERN_PASTURE_ID =  Biome.getIdForBiome(JURASSIC_FERN_PASTURE);
    public Biome JURASSIC_GARRIGUE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_garrigue"));
    public int JURASSIC_GARRIGUE_ID =  Biome.getIdForBiome(JURASSIC_GARRIGUE);
    public Biome JURASSIC_FLOODPLAIN_FORESTED = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_floodplain_forested"));
    public int JURASSIC_FLOODPLAIN_FORESTED_ID =  Biome.getIdForBiome(JURASSIC_FLOODPLAIN_FORESTED);
    public Biome JURASSIC_GINKGO_WOODLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ginkgo_woodland"));
    public int JURASSIC_GINKGO_WOODLAND_ID =  Biome.getIdForBiome(JURASSIC_GINKGO_WOODLAND);
    public Biome JURASSIC_REDWOOD_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_coniferous_forest"));
    public int JURASSIC_REDWOOD_FOREST_ID =  Biome.getIdForBiome(JURASSIC_REDWOOD_FOREST);
    public Biome JURASSIC_ROUGH_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_rough_hills"));
    public int JURASSIC_ROUGH_HILLS_ID =  Biome.getIdForBiome(JURASSIC_ROUGH_HILLS);
    public Biome JURASSIC_TAIGA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_southern_taiga"));
    public int JURASSIC_TAIGA_ID =  Biome.getIdForBiome(JURASSIC_TAIGA);

    public GenLayerDesertNotBySea(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int JurassicBiomes[] = new int[] {
            JURASSIC_FERN_PASTURE_ID,
            JURASSIC_GARRIGUE_ID,
            JURASSIC_FLOODPLAIN_FORESTED_ID,
            JURASSIC_GINKGO_WOODLAND_ID,
            JURASSIC_REDWOOD_FOREST_ID,
            JURASSIC_ROUGH_HILLS_ID,
            JURASSIC_TAIGA_ID
    };

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaHeight; ++i)
        {
            for (int j = 0; j < areaWidth; ++j)
            {
                this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];

                if (isDesert(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (
                        (isSea(l1) || isSea(k2) || isSea(j3) || isSea(i4))

                    )
                    {
                        aint1[j + i * areaWidth] = JurassicBiomes[nextInt(JurassicBiomes.length)];
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

    private boolean isDesert(int biomeID) {
        if (biomeID == JURASSIC_DESERT_ID) {
            return true;
        }
        return false;
    }

    private boolean isSea(int biomeID) {
        if (biomeID == JURASSIC_OCEAN_SHORE_ID) {
            return true;
        }
        return false;
    }

}
