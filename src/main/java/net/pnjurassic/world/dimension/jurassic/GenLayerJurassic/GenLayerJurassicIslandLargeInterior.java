package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerJurassicIslandLargeInterior extends GenLayer
{

    public Biome JURASSIC_ISLANDS_LARGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_large"));
    public int JURASSIC_ISLANDS_LARGE_ID =  Biome.getIdForBiome(JURASSIC_ISLANDS_LARGE);
    public Biome JURASSIC_ISLANDS_LARGE_SCRUB = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_large_scrub"));
    public int JURASSIC_ISLANDS_LARGE_SCRUB_ID =  Biome.getIdForBiome(JURASSIC_ISLANDS_LARGE_SCRUB);
    public Biome JURASSIC_ISLANDS_LARGE_WET = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_large_wet"));
    public int JURASSIC_ISLANDS_LARGE_WET_ID =  Biome.getIdForBiome(JURASSIC_ISLANDS_LARGE_WET);
    public Biome JURASSIC_ISLANDS_LARGE_FIELD = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_large_field"));
    public int JURASSIC_ISLANDS_LARGE_FIELD_ID =  Biome.getIdForBiome(JURASSIC_ISLANDS_LARGE_FIELD);

    public GenLayerJurassicIslandLargeInterior(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int CraterBiomes[] = new int[] {
            JURASSIC_ISLANDS_LARGE_SCRUB_ID,
            JURASSIC_ISLANDS_LARGE_SCRUB_ID,
            JURASSIC_ISLANDS_LARGE_SCRUB_ID,
            JURASSIC_ISLANDS_LARGE_WET_ID,
            JURASSIC_ISLANDS_LARGE_WET_ID,
            JURASSIC_ISLANDS_LARGE_FIELD_ID,
            JURASSIC_ISLANDS_LARGE_FIELD_ID
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
                //Biome biome = Biome.getBiome(k);

                if (isCraterWall(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isCraterWall(l1) && isCraterWall(k2) && isCraterWall(j3) && isCraterWall(i4))
                    {
                        aint1[j + i * areaWidth] = CraterBiomes[nextInt(CraterBiomes.length)];
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

    private boolean isCraterWall(int biomeID) {
        if (biomeID == JURASSIC_ISLANDS_LARGE_ID
        ) {
            return true;
        }
        return false;
    }

}
