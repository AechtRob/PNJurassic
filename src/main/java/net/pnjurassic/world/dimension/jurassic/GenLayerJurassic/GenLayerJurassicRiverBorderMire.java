package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerJurassicRiverBorderMire extends GenLayer
{

    public  Biome JURASSIC_RIVER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_river"));
    public  int JURASSIC_RIVER_ID =  Biome.getIdForBiome(JURASSIC_RIVER);

    public  Biome JURASSIC_MIRE_LAKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mire_lakes"));
    public  int JURASSIC_MIRE_LAKES_ID =  Biome.getIdForBiome(JURASSIC_MIRE_LAKES);

    public Biome JURASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_shore"));
    public int JURASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(JURASSIC_OCEAN_SHORE);
    public Biome JURASSIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean"));
    public  int JURASSIC_OCEAN_ID =  Biome.getIdForBiome(JURASSIC_OCEAN);
    public  Biome JURASSIC_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_beach"));
    public  int JURASSIC_BEACH_ID =  Biome.getIdForBiome(JURASSIC_BEACH);
    public  Biome JURASSIC_BEACH_BLACK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_beach_black"));
    public  int JURASSIC_BEACH_BLACK_ID =  Biome.getIdForBiome(JURASSIC_BEACH_BLACK);

    public Biome JURASSIC_MIRE_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mire_helper"));
    public int JURASSIC_MIRE_HELPER_ID =  Biome.getIdForBiome(JURASSIC_MIRE_HELPER);
    public Biome JURASSIC_MIRE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mire"));
    public int JURASSIC_MIRE_ID =  Biome.getIdForBiome(JURASSIC_MIRE);

    public Biome JURASSIC_LAKE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_lakes"));
    public int JURASSIC_LAKE_ID =  Biome.getIdForBiome(JURASSIC_LAKE);
    public Biome JURASSIC_LAKE_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_lake_shore"));
    public int JURASSIC_LAKE_SHORE_ID =  Biome.getIdForBiome(JURASSIC_LAKE_SHORE);
    public Biome JURASSIC_OCEAN_RAFTS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_rafts"));
    public int JURASSIC_OCEAN_RAFTS_ID =  Biome.getIdForBiome(JURASSIC_OCEAN_RAFTS);
    public Biome JURASSIC_CORAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_coral"));
    public int JURASSIC_CORAL_ID =  Biome.getIdForBiome(JURASSIC_CORAL);

    public GenLayerJurassicRiverBorderMire(long seed, GenLayer genLayer)
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

                //if (!hasNoBeach(k))
                //{
                if (isMudflats(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if ((!isMudflats(l1) && !isOceanOrBeach(l1))
                            || (!isMudflats(k2) && !isOceanOrBeach(k2))
                            || (!isMudflats(j3) && !isOceanOrBeach(j3))
                            || (!isMudflats(i4) && !isOceanOrBeach(i4))
                    ) {
                        aint1[j + i * areaWidth] = JURASSIC_MIRE_LAKES_ID;
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                if (isMudflatsHelper(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if ((!isMudflatsHelper(l1) && !isOceanOrBeach(l1))
                            || (!isMudflatsHelper(k2) && !isOceanOrBeach(k2))
                            || (!isMudflatsHelper(j3) && !isOceanOrBeach(j3))
                            || (!isMudflatsHelper(i4) && !isOceanOrBeach(i4))
                    ) {
                        aint1[j + i * areaWidth] = JURASSIC_MIRE_LAKES_ID;
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

    private boolean isOceanOrBeach(int biomeID) {
        return biomeID == JURASSIC_OCEAN_ID || biomeID == JURASSIC_OCEAN_SHORE_ID
                || biomeID == JURASSIC_BEACH_ID || biomeID == JURASSIC_BEACH_BLACK_ID
                || biomeID == JURASSIC_LAKE_ID
                || biomeID == JURASSIC_LAKE_SHORE_ID
                || biomeID == JURASSIC_RIVER_ID
                || biomeID == JURASSIC_CORAL_ID
                || biomeID == JURASSIC_OCEAN_RAFTS_ID;
    }

    private boolean isMudflats(int biomeID) {
        return biomeID == JURASSIC_MIRE_ID;
    }

    private boolean isMudflatsHelper(int biomeID) {
        return biomeID == JURASSIC_MIRE_HELPER_ID;
    }

}
