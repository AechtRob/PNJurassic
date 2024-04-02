package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerJurassicEstuary1 extends GenLayer
{

    public  Biome JURASSIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean"));
    public  int JURASSIC_OCEAN_ID =  Biome.getIdForBiome(JURASSIC_OCEAN);
    public  Biome JURASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_shore"));
    public  int JURASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(JURASSIC_OCEAN_SHORE);



    public  Biome JURASSIC_BOULDERS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_boulders"));
    public  int JURASSIC_BOULDERS_ID =  Biome.getIdForBiome(JURASSIC_BOULDERS);
    public  Biome JURASSIC_OUTCROPS_EDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_outcrops_edge"));
    public  int JURASSIC_OUTCROPS_EDGE_ID =  Biome.getIdForBiome(JURASSIC_OUTCROPS_EDGE);
    public  Biome JURASSIC_OUTCROPS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_outcrops"));
    public  int JURASSIC_OUTCROPS_ID =  Biome.getIdForBiome(JURASSIC_OUTCROPS);
    public  Biome JURASSIC_REDWOOD_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_coniferous_hills"));
    public  int JURASSIC_REDWOOD_HILLS_ID =  Biome.getIdForBiome(JURASSIC_REDWOOD_HILLS);
    public  Biome JURASSIC_REDWOOD_MOUNTAINS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_coniferous_mountains"));
    public  int JURASSIC_REDWOOD_MOUNTAINS_ID =  Biome.getIdForBiome(JURASSIC_REDWOOD_MOUNTAINS);
   
    public  Biome JURASSIC_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mudflats_estuary_helper"));
    public  int JURASSIC_ESTUARY_ID =  Biome.getIdForBiome(JURASSIC_ESTUARY);
    public Biome JURASSIC_OCEAN_RAFTS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_rafts"));
    public int JURASSIC_OCEAN_RAFTS_ID =  Biome.getIdForBiome(JURASSIC_OCEAN_RAFTS);
    public Biome JURASSIC_CORAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_coral"));
    public int JURASSIC_CORAL_ID =  Biome.getIdForBiome(JURASSIC_CORAL);

    public GenLayerJurassicEstuary1(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaHeight; ++i)
        {
            for (int j = 0; j < areaWidth; ++j)
            {
                this.initChunkSeed(j + areaX, i + areaY);
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];

                if (k != JURASSIC_BOULDERS_ID
                    && k != JURASSIC_OUTCROPS_EDGE_ID
                    && k != JURASSIC_OUTCROPS_ID
                    && k != JURASSIC_REDWOOD_HILLS_ID
                    && k != JURASSIC_REDWOOD_MOUNTAINS_ID
                )
                {
                    if (!isOcean(k))
                    {
                        int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                        int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                        int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                        int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                        if (!isOcean(l1) && !isOcean(k2) && !isOcean(j3) && !isOcean(i4))
                        {
                            aint1[j + i * areaWidth] = k;
                        }
                        else
                        {
                            if (nextInt(8) == 0) {
                                aint1[j + i * areaWidth] = JURASSIC_ESTUARY_ID;
                            }
                            else {
                                aint1[j + i * areaWidth] = k;
                            }
                        }
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

    private boolean isOcean(int biomeID) {
        return biomeID == JURASSIC_OCEAN_ID || biomeID == JURASSIC_OCEAN_SHORE_ID
                || biomeID == JURASSIC_OCEAN_RAFTS_ID || biomeID == JURASSIC_CORAL_ID;
    }

}
