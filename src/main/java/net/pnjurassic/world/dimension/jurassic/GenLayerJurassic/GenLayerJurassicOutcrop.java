package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.lepidodendron.util.EnumBiomeTypeDevonian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnjurassic.world.biome.jurassic.*;

public class GenLayerJurassicOutcrop extends GenLayer {

    public Biome JURASSIC_FLOODPLAIN_FORESTED = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_floodplain_forested"));
    public int JURASSIC_FLOODPLAIN_FORESTED_ID =  Biome.getIdForBiome(JURASSIC_FLOODPLAIN_FORESTED);
    public Biome JURASSIC_GINKGO_WOODLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ginkgo_woodland"));
    public int JURASSIC_GINKGO_WOODLAND_ID =  Biome.getIdForBiome(JURASSIC_GINKGO_WOODLAND);
    public Biome JURASSIC_GINKGO_PARKLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ginkgo_parkland"));
    public int JURASSIC_GINKGO_PARKLAND_ID =  Biome.getIdForBiome(JURASSIC_GINKGO_PARKLAND);
    public Biome JURASSIC_REDWOOD_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_coniferous_forest"));
    public int JURASSIC_REDWOOD_FOREST_ID =  Biome.getIdForBiome(JURASSIC_REDWOOD_FOREST);
    public Biome JURASSIC_FLOODPLAIN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_floodplain"));
    public int JURASSIC_FLOODPLAIN_ID =  Biome.getIdForBiome(JURASSIC_FLOODPLAIN);
    public Biome JURASSIC_OUTCROP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_outcrops"));
    public int JURASSIC_OUTCROP_ID =  Biome.getIdForBiome(JURASSIC_OUTCROP);


    private final int FloodplainForestedBiomes[] = new int[] {
        JURASSIC_FLOODPLAIN_FORESTED_ID,
        JURASSIC_FLOODPLAIN_FORESTED_ID,
        JURASSIC_FLOODPLAIN_FORESTED_ID,
        JURASSIC_FLOODPLAIN_FORESTED_ID,
        JURASSIC_FLOODPLAIN_FORESTED_ID,
        JURASSIC_FLOODPLAIN_FORESTED_ID,
        JURASSIC_FLOODPLAIN_FORESTED_ID,
        JURASSIC_FLOODPLAIN_FORESTED_ID,
        JURASSIC_OUTCROP_ID
    };
    private final int FloodplainBiomes[] = new int[] {
        JURASSIC_FLOODPLAIN_ID,
        JURASSIC_FLOODPLAIN_ID,
        JURASSIC_FLOODPLAIN_ID,
        JURASSIC_FLOODPLAIN_ID,
        JURASSIC_FLOODPLAIN_ID,
        JURASSIC_FLOODPLAIN_ID,
        JURASSIC_FLOODPLAIN_ID,
        JURASSIC_FLOODPLAIN_ID,
        JURASSIC_OUTCROP_ID
    };
    private final int GinkgoBiomes[] = new int[] {
        JURASSIC_GINKGO_WOODLAND_ID,
        JURASSIC_GINKGO_WOODLAND_ID,
        JURASSIC_GINKGO_WOODLAND_ID,
        JURASSIC_GINKGO_WOODLAND_ID,
        JURASSIC_GINKGO_WOODLAND_ID,
        JURASSIC_GINKGO_WOODLAND_ID,
        JURASSIC_GINKGO_WOODLAND_ID,
        JURASSIC_GINKGO_WOODLAND_ID,
        JURASSIC_OUTCROP_ID
    };
    private final int GinkgoParklandBiomes[] = new int[] {
            JURASSIC_GINKGO_PARKLAND_ID,
            JURASSIC_GINKGO_PARKLAND_ID,
            JURASSIC_GINKGO_PARKLAND_ID,
            JURASSIC_GINKGO_PARKLAND_ID,
            JURASSIC_GINKGO_PARKLAND_ID,
            JURASSIC_GINKGO_PARKLAND_ID,
            JURASSIC_GINKGO_PARKLAND_ID,
            JURASSIC_GINKGO_PARKLAND_ID,
            JURASSIC_OUTCROP_ID
    };
    private final int RedwoodBiomes[] = new int[] {
        JURASSIC_REDWOOD_FOREST_ID,
        JURASSIC_REDWOOD_FOREST_ID,
        JURASSIC_REDWOOD_FOREST_ID,
        JURASSIC_REDWOOD_FOREST_ID,
        JURASSIC_REDWOOD_FOREST_ID,
        JURASSIC_REDWOOD_FOREST_ID,
        JURASSIC_REDWOOD_FOREST_ID,
        JURASSIC_REDWOOD_FOREST_ID,
        JURASSIC_OUTCROP_ID
    };

    public GenLayerJurassicOutcrop(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        return diversify(x, z, width, height);
    }

    private int[] diversify(int x, int z, int width, int height) {
        int input[] = this.parent.getInts(x, z, width, height);
        int output[] = IntCache.getIntCache(width * height);
        EnumBiomeTypeDevonian type;
        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                if (nextInt(2) == 0) {
                    if (Biome.getBiome(center) == BiomeJurassicFloodplainForested.biome)
                        output[i] = FloodplainForestedBiomes[nextInt(FloodplainForestedBiomes.length)];
                    else if (Biome.getBiome(center) == BiomeJurassicFloodplain.biome)
                        output[i] = FloodplainBiomes[nextInt(FloodplainBiomes.length)];
                    else if (Biome.getBiome(center) == BiomeJurassicGinkgoWoodland.biome)
                        output[i] = GinkgoBiomes[nextInt(GinkgoBiomes.length)];
                    else if (Biome.getBiome(center) == BiomeJurassicGinkgoParkland.biome)
                        output[i] = GinkgoParklandBiomes[nextInt(GinkgoBiomes.length)];
                    else if (Biome.getBiome(center) == BiomeJurassicConiferousForest.biome)
                        output[i] = RedwoodBiomes[nextInt(RedwoodBiomes.length)];
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}