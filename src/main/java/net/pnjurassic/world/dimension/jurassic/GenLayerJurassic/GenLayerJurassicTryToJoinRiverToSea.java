package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.lepidodendron.util.EnumBiomeTypeJurassic;
import net.lepidodendron.world.biome.jurassic.BiomeJurassic;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerJurassicTryToJoinRiverToSea extends GenLayer
{
    public  Biome JURASSIC_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_beach"));
    public  int JURASSIC_BEACH_ID =  Biome.getIdForBiome(JURASSIC_BEACH);
    public  Biome JURASSIC_BLACK_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_beach_black"));
    public  int JURASSIC_BLACK_BEACH_ID =  Biome.getIdForBiome(JURASSIC_BLACK_BEACH);
    public  Biome JURASSIC_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mudflats_estuary"));
    public  int JURASSIC_ESTUARY_ID =  Biome.getIdForBiome(JURASSIC_ESTUARY);
    public  Biome JURASSIC_ESTUARY_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mudflats_estuary_helper"));
    public  int JURASSIC_ESTUARY_HELPER_ID =  Biome.getIdForBiome(JURASSIC_ESTUARY_HELPER);
    public Biome JURASSIC_ESTUARY_FLAT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mudflats_estuary_flat"));
    public int JURASSIC_ESTUARY_FLAT_ID =  Biome.getIdForBiome(JURASSIC_ESTUARY_FLAT);

    public  Biome JURASSIC_RIVER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_river"));
    public  int JURASSIC_RIVER_ID =  Biome.getIdForBiome(JURASSIC_RIVER);

    public  Biome JURASSIC_SHALLOW_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_shore"));
    public  int JURASSIC_SHALLOW_OCEAN_ID =  Biome.getIdForBiome(JURASSIC_SHALLOW_OCEAN);
    public Biome JURASSIC_OCEAN_RAFTS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_rafts"));
    public int JURASSIC_OCEAN_RAFTS_ID =  Biome.getIdForBiome(JURASSIC_OCEAN_RAFTS);
    public Biome JURASSIC_CORAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_coral"));
    public int JURASSIC_CORAL_ID =  Biome.getIdForBiome(JURASSIC_CORAL);

    public
    GenLayerJurassicTryToJoinRiverToSea(long seed, GenLayer genLayer)
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

                if (isBeach(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if ((isOcean(l1)
                            && ((isRiver(k2) && !isRiver(j3) && !isRiver(i4))
                            || (isRiver(j3) && !isRiver(k2) && !isRiver(i4))
                            || (isRiver(i4) && !isRiver(k2) && !isRiver(j3))
                        ))
                            ||
                        (isOcean(k2)
                            && ((isRiver(l1) && !isRiver(j3) && !isRiver(i4))
                            || (isRiver(j3) && !isRiver(l1) && !isRiver(i4))
                            || (isRiver(i4) && !isRiver(l1) && !isRiver(j3))
                        ))
                            ||
                        (isOcean(j3)
                            && ((isRiver(l1) && !isRiver(k2) && !isRiver(i4))
                            || (isRiver(k2) && !isRiver(l1) && !isRiver(i4))
                            || (isRiver(i4) && !isRiver(l1) && !isRiver(k2))
                        ))
                            ||
                        (isOcean(i4)
                            && ((isRiver(l1) && !isRiver(k2) && !isRiver(j3))
                            || (isRiver(k2) && !isRiver(l1) && !isRiver(j3))
                            || (isRiver(j3) && !isRiver(l1) && !isRiver(k2))
                        ))
                        )
                    {
                        aint1[j + i * areaWidth] = JURASSIC_RIVER_ID;
                    }
                    if (isRiver(l1) ||
                            isRiver(k2) ||
                            isRiver(j3) ||
                            isRiver(i4)
                        )
                    {
                        aint1[j + i * areaWidth] = JURASSIC_SHALLOW_OCEAN_ID;
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
        Biome biome = Biome.getBiome(biomeID);
        if (biome instanceof BiomeJurassic) {
            BiomeJurassic biomeJurassic = (BiomeJurassic) biome;
            return biomeJurassic.getBiomeType() == EnumBiomeTypeJurassic.Ocean
                    && biomeID != JURASSIC_BEACH_ID
                    && biomeID != JURASSIC_BLACK_BEACH_ID;
        }
        return false;
    }

    private boolean isBeach(int biomeID) {
        return biomeID == JURASSIC_BEACH_ID
                || biomeID == JURASSIC_BLACK_BEACH_ID
                || biomeID == JURASSIC_ESTUARY_ID
                || biomeID == JURASSIC_ESTUARY_FLAT_ID
                || biomeID == JURASSIC_ESTUARY_HELPER_ID;
    }

    private boolean isRiver(int biomeID) {
        return biomeID == JURASSIC_RIVER_ID;
    }


}
