package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerJurassicRafts extends GenLayer {


    public Biome JURASSIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean"));
    public int JURASSIC_OCEAN_ID =  Biome.getIdForBiome(JURASSIC_OCEAN);
    public Biome JURASSIC_OCEAN_RAFTS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_rafts"));
    public int JURASSIC_OCEAN_RAFTS_ID =  Biome.getIdForBiome(JURASSIC_OCEAN_RAFTS);

    private final int OceanBiomes[] = new int[] {
            JURASSIC_OCEAN_ID,
            JURASSIC_OCEAN_ID,
            JURASSIC_OCEAN_ID,
            JURASSIC_OCEAN_ID,
            JURASSIC_OCEAN_ID,
            JURASSIC_OCEAN_ID,
            JURASSIC_OCEAN_ID,
            JURASSIC_OCEAN_RAFTS_ID
    };

    public GenLayerJurassicRafts(long seed, GenLayer genlayer) {
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
                this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];

                if (isOcean(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isOcean(l1) && isOcean(k2) && isOcean(j3) && isOcean(i4))
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

    private boolean isOcean(int biomeID) {
        if (biomeID == JURASSIC_OCEAN_ID
            || biomeID == JURASSIC_OCEAN_RAFTS_ID) {
            return true;
        }
        return false;
    }

}