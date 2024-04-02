package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerJurassicCoral extends GenLayer {


    public  Biome JURASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_shore"));
    public  int JURASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(JURASSIC_OCEAN_SHORE);
    public Biome JURASSIC_CORAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_coral"));
    public int JURASSIC_CORAL_ID =  Biome.getIdForBiome(JURASSIC_CORAL);

    private final int[] OceanBiomes = new int[] {
            JURASSIC_OCEAN_SHORE_ID,
            JURASSIC_OCEAN_SHORE_ID,
            JURASSIC_OCEAN_SHORE_ID,
            JURASSIC_OCEAN_SHORE_ID,
            JURASSIC_OCEAN_SHORE_ID,
            JURASSIC_OCEAN_SHORE_ID,
            JURASSIC_OCEAN_SHORE_ID,
            JURASSIC_OCEAN_SHORE_ID,
            JURASSIC_CORAL_ID
    };

    public GenLayerJurassicCoral(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    @Override
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

                if (isShallowOcean(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isShallowOcean(l1) || isShallowOcean(k2) || isShallowOcean(j3) || isShallowOcean(i4))
                    {
                        aint1[j + i * areaWidth] = OceanBiomes[nextInt(OceanBiomes.length)];
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

    private boolean isShallowOcean(int biomeID) {
        return biomeID == JURASSIC_OCEAN_SHORE_ID;
    }

}