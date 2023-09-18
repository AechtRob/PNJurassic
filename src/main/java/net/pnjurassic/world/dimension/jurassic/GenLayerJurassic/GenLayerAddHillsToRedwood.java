package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerAddHillsToRedwood extends GenLayer
{

    public Biome JURASSIC_REDWOOD_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_coniferous_forest"));
    public int JURASSIC_REDWOOD_FOREST_ID =  Biome.getIdForBiome(JURASSIC_REDWOOD_FOREST);

    public Biome JURASSIC_REDWOOD_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_coniferous_hills"));
    public int JURASSIC_REDWOOD_HILLS_ID =  Biome.getIdForBiome(JURASSIC_REDWOOD_HILLS);

    public GenLayerAddHillsToRedwood(long seed, GenLayer genLayer)
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
                this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];
                //Biome biome = Biome.getBiome(k);

                if (isRedwood(k))
                {

                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isRedwood(l1) && isRedwood(k2) && isRedwood(j3) && isRedwood(i4) && nextInt(2) == 0)
                    {
                        aint1[j + i * areaWidth] = JURASSIC_REDWOOD_HILLS_ID;
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

    private boolean isRedwood(int biomeID) {
        if (biomeID == JURASSIC_REDWOOD_FOREST_ID) {
            return true;
        }
        return false;
    }

}
