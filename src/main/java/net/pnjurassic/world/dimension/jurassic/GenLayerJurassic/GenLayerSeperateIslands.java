package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerSeperateIslands extends GenLayer
{

    public Biome JURASSIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean"));
    public int JURASSIC_OCEAN_ID =  Biome.getIdForBiome(JURASSIC_OCEAN);
    public Biome JURASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_shore"));
    public int JURASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(JURASSIC_OCEAN_SHORE);
    public Biome JURASSIC_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_glass_sponge_reef"));
    public int JURASSIC_REEF_ID =  Biome.getIdForBiome(JURASSIC_REEF);
    public Biome JURASSIC_CORAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_coral"));
    public int JURASSIC_CORAL_ID =  Biome.getIdForBiome(JURASSIC_CORAL);
    public Biome JURASSIC_RAFTS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_rafts"));
    public int JURASSIC_RAFTS_ID =  Biome.getIdForBiome(JURASSIC_RAFTS);

    public Biome JURASSIC_ATOLLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_sandy"));
    public int JURASSIC_ATOLLS_ID =  Biome.getIdForBiome(JURASSIC_ATOLLS);
    public Biome JURASSIC_ATOLLS2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_sandy_forest"));
    public int JURASSIC_ATOLLS2_ID =  Biome.getIdForBiome(JURASSIC_ATOLLS2);
    public Biome JURASSIC_ISLANDS_SANDY_WHITE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_sandy_white"));
    public int JURASSIC_ISLANDS_SANDY_WHITE_ID =  Biome.getIdForBiome(JURASSIC_ISLANDS_SANDY_WHITE);
    public Biome JURASSIC_ISLANDS_SANDY_WHITE_EDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_sandy_white_edge"));
    public int JURASSIC_ISLANDS_SANDY_WHITE_EDGE_ID =  Biome.getIdForBiome(JURASSIC_ISLANDS_SANDY_WHITE_EDGE);
    public Biome JURASSIC_ATOLLS3 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_sandy_hills"));
    public int JURASSIC_ATOLLS3_ID =  Biome.getIdForBiome(JURASSIC_ATOLLS3);
    public Biome JURASSIC_ISLANDS_LARGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_large"));
    public int JURASSIC_ISLANDS_LARGE_ID =  Biome.getIdForBiome(JURASSIC_ISLANDS_LARGE);
    public Biome JURASSIC_ISLANDS_LARGE_RIM = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_large_rim"));
    public int JURASSIC_ISLANDS_LARGE_RIM_ID =  Biome.getIdForBiome(JURASSIC_ISLANDS_LARGE_RIM);
    public Biome JURASSIC_ISLANDS_LARGE_SCRUB = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_large_scrub"));
    public int JURASSIC_ISLANDS_LARGE_SCRUB_ID =  Biome.getIdForBiome(JURASSIC_ISLANDS_LARGE_SCRUB);
    public Biome JURASSIC_ISLANDS_LARGE_WET = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_large_wet"));
    public int JURASSIC_ISLANDS_LARGE_WET_ID =  Biome.getIdForBiome(JURASSIC_ISLANDS_LARGE_WET);
    public Biome JURASSIC_ISLANDS_LARGE_FIELD = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_large_field"));
    public int JURASSIC_ISLANDS_LARGE_FIELD_ID =  Biome.getIdForBiome(JURASSIC_ISLANDS_LARGE_FIELD);

    public Biome JURASSIC_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_beach"));
    public int JURASSIC_BEACH_ID =  Biome.getIdForBiome(JURASSIC_BEACH);

    public GenLayerSeperateIslands(long seed, GenLayer genLayer)
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
                //Biome biome = Biome.getBiome(k);

                if (!isOcean(k) && !isWhiteIslands(k) && !isSandyIslands(k) && !isLargeIslands(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isWhiteIslands(l1) || isWhiteIslands(k2) || isWhiteIslands(j3) || isWhiteIslands(i4)
                        || isSandyIslands(l1) || isSandyIslands(k2) || isSandyIslands(j3) || isSandyIslands(i4)
                        || isLargeIslands(l1) || isLargeIslands(k2) || isLargeIslands(j3) || isLargeIslands(i4))
                    {
                        aint1[j + i * areaWidth] = JURASSIC_OCEAN_SHORE_ID;
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
                || biomeID == JURASSIC_REEF_ID || biomeID == JURASSIC_RAFTS_ID
                || biomeID == JURASSIC_CORAL_ID;
    }

    private boolean isSandyIslands(int biomeID) {
        return biomeID == JURASSIC_ATOLLS_ID || biomeID == JURASSIC_ATOLLS2_ID
                || biomeID == JURASSIC_ATOLLS3_ID;
    }

    private boolean isWhiteIslands(int biomeID) {
        return biomeID == JURASSIC_ISLANDS_SANDY_WHITE_ID
                || biomeID == JURASSIC_ISLANDS_SANDY_WHITE_EDGE_ID;
    }

    private boolean isLargeIslands(int biomeID) {
        return biomeID == JURASSIC_ISLANDS_LARGE_ID
                || biomeID == JURASSIC_ISLANDS_LARGE_RIM_ID
                || biomeID == JURASSIC_ISLANDS_LARGE_SCRUB_ID
                || biomeID == JURASSIC_ISLANDS_LARGE_WET_ID
                || biomeID == JURASSIC_ISLANDS_LARGE_FIELD_ID;
    }

}
