package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerDesertTransitionDesertSide extends GenLayer
{

    public Biome DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_desert"));
    public int DESERT_ID =  Biome.getIdForBiome(DESERT);
    public Biome DESERT_TRANSITION_DESERT_SIDE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_desert_rim_desert_side"));
    public int DESERT_TRANSITION_DESERT_SIDE_ID =  Biome.getIdForBiome(DESERT_TRANSITION_DESERT_SIDE);

    public GenLayerDesertTransitionDesertSide(long seed, GenLayer genLayer)
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

                if (isDesert(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isDesert(l1) && isDesert(k2) && isDesert(j3) && isDesert(i4))
                    {
                        aint1[j + i * areaWidth] = DESERT_ID;
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
        return biomeID == DESERT_TRANSITION_DESERT_SIDE_ID;
    }

}
