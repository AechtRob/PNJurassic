package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerJurassicOutcropBlend2 extends GenLayer {

    public Biome JURASSIC_ROUGH_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_rough_hills"));
    public int JURASSIC_ROUGH_HILLS_ID =  Biome.getIdForBiome(JURASSIC_ROUGH_HILLS);

    public Biome JURASSIC_OUTCROP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_outcrops"));
    public int JURASSIC_OUTCROP_ID =  Biome.getIdForBiome(JURASSIC_OUTCROP);
    public Biome JURASSIC_OUTCROP_EDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_outcrops_edge"));
    public int JURASSIC_OUTCROP_EDGE_ID =  Biome.getIdForBiome(JURASSIC_OUTCROP_EDGE);

    public Biome JURASSIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean"));
    public  int JURASSIC_OCEAN_ID =  Biome.getIdForBiome(JURASSIC_OCEAN);
    public  Biome JURASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_shore"));
    public  int JURASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(JURASSIC_OCEAN_SHORE);
    public  Biome JURASSIC_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_beach"));
    public  int JURASSIC_BEACH_ID =  Biome.getIdForBiome(JURASSIC_BEACH);
    public  Biome JURASSIC_RIVERBANK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_riverbank"));
    public  int JURASSIC_RIVERBANK_ID =  Biome.getIdForBiome(JURASSIC_RIVERBANK);
    public  Biome JURASSIC_RIVER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_river"));
    public  int JURASSIC_RIVER_ID =  Biome.getIdForBiome(JURASSIC_RIVER);

    public GenLayerJurassicOutcropBlend2(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    private final int[] HighlandBiomes = new int[] {
            JURASSIC_OUTCROP_ID,
            JURASSIC_OUTCROP_EDGE_ID,
            JURASSIC_OUTCROP_EDGE_ID,
            JURASSIC_OUTCROP_EDGE_ID,
            JURASSIC_OUTCROP_EDGE_ID
    };

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
                //Biome biome = Biome.getBiome(k);

                //if (!hasNoBeach(k))
                //{
                    if (!isOutcropEdge(k))
                    {
                        int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                        int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                        int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                        int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                        if (isOutcropEdge(l1) && isOutcropEdge(k2) && isOutcropEdge(j3) && isOutcropEdge(i4))
                        {
                            aint1[j + i * areaWidth] = JURASSIC_OUTCROP_ID;
                        }
                        else
                        {
                            aint1[j + i * areaWidth] = k;
                        }
                    //}
                    //else
                    //{
                    //    aint1[j + i * areaWidth] = k;
                    //}
                }
                else
                {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }
        return aint1;
    }

    private boolean isOutcropEdge(int biomeID) {
        return biomeID == JURASSIC_OUTCROP_EDGE_ID;
    }

}