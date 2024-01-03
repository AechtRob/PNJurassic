package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerJurassicDesertRimFromHills extends GenLayer
{
    public Biome JURASSIC_OUTCROPS_EDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_outcrops_edge"));
    public int JURASSIC_OUTCROPS_EDGE_ID =  Biome.getIdForBiome(JURASSIC_OUTCROPS_EDGE);
    public Biome JURASSIC_OUTCROPS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_outcrops"));
    public int JURASSIC_OUTCROPS_ID =  Biome.getIdForBiome(JURASSIC_OUTCROPS);
    public Biome JURASSIC_CONIFEROUS_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_coniferous_hills"));
    public int JURASSIC_CONIFEROUS_HILLS_ID =  Biome.getIdForBiome(JURASSIC_CONIFEROUS_HILLS);
    public Biome JURASSIC_CONIFEROUS_MTS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_coniferous_mountains"));
    public int JURASSIC_CONIFEROUS_MTS_ID =  Biome.getIdForBiome(JURASSIC_CONIFEROUS_MTS);
    public Biome JURASSIC_ROUGH_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_rough_hills"));
    public int JURASSIC_ROUGH_HILLS_ID =  Biome.getIdForBiome(JURASSIC_ROUGH_HILLS);
    public Biome JURASSIC_BOULDERS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_boulders"));
    public int JURASSIC_BOULDERS_ID =  Biome.getIdForBiome(JURASSIC_BOULDERS);

    public Biome DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_desert"));
    public int DESERT_ID =  Biome.getIdForBiome(DESERT);
    public Biome DESERT_TRANSITION = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_desert_rim"));
    public int DESERT_TRANSITION_ID =  Biome.getIdForBiome(DESERT_TRANSITION);
    public Biome DESERT_TRANSITION_DESERT_SIDE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_desert_rim_desert_side"));
    public int DESERT_TRANSITION_DESERT_SIDE_ID =  Biome.getIdForBiome(DESERT_TRANSITION_DESERT_SIDE);

    public Biome DESERT_TRANSITION_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_desert_rim_helper"));
    public int DESERT_TRANSITION_HELPER_ID =  Biome.getIdForBiome(DESERT_TRANSITION_HELPER);

    public GenLayerJurassicDesertRimFromHills(long seed, GenLayer genLayer)
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

                if (isHillsBiome(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if ((isDesert(l1))
                        || (isDesert(k2))
                        || (isDesert(j3))
                        || (isDesert(i4))
                    )
                    {
                        aint1[j + i * areaWidth] = DESERT_TRANSITION_HELPER_ID;
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
        if (biomeID == DESERT_ID
                || biomeID == DESERT_TRANSITION_DESERT_SIDE_ID
                || biomeID == DESERT_TRANSITION_ID) {
            return true;
        }
        return false;
    }

    private boolean isHillsBiome(int biomeID) {
        if (biomeID == JURASSIC_BOULDERS_ID
                || biomeID == JURASSIC_CONIFEROUS_HILLS_ID
                || biomeID == JURASSIC_CONIFEROUS_MTS_ID
                || biomeID == JURASSIC_ROUGH_HILLS_ID
                || biomeID == JURASSIC_OUTCROPS_ID
                || biomeID == JURASSIC_OUTCROPS_EDGE_ID) {
            return true;
        }
        return false;
    }

}
