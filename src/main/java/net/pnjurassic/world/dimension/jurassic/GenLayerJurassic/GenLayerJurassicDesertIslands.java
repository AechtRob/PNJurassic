package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerJurassicDesertIslands extends GenLayer
{

    public Biome DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_desert"));
    public int DESERT_ID =  Biome.getIdForBiome(DESERT);
    public Biome DESERT_ISLANDS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_desert_island"));
    public int DESERT_ISLANDS_ID =  Biome.getIdForBiome(DESERT_ISLANDS);

    public GenLayerJurassicDesertIslands(long seed, GenLayer genLayer)
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

                if (isDesert(k) && nextInt(14) == 0)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if ((isIslandable(l1))
                        && (isIslandable(k2))
                        && (isIslandable(j3))
                        && (isIslandable(i4))
                    )
                    {
                        aint1[j + i * areaWidth] = DESERT_ISLANDS_ID;
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
        if (biomeID == DESERT_ID) {
            return true;
        }
        return false;
    }

    private boolean isIslandable(int biomeID) {
        if (biomeID == DESERT_ID
            || biomeID == DESERT_ISLANDS_ID) {
            return true;
        }
        return false;
    }

}
