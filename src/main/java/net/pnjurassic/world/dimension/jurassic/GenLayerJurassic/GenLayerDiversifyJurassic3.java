package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnjurassic.world.biome.jurassic.BiomeJurassicGarrigue;
import net.pnjurassic.world.biome.jurassic.BiomeJurassicGinkgoWoodland;

public class GenLayerDiversifyJurassic3 extends GenLayer {

    public Biome JURASSIC_GARRIGUE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_garrigue"));
    public int JURASSIC_GARRIGUE_ID =  Biome.getIdForBiome(JURASSIC_GARRIGUE);
    public Biome JURASSIC_COPSE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_garrigue_copse"));
    public int JURASSIC_COPSE_ID =  Biome.getIdForBiome(JURASSIC_COPSE);

    public Biome JURASSIC_GINKGO = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ginkgo_woodland"));
    public int JURASSIC_GINKGO_ID =  Biome.getIdForBiome(JURASSIC_GINKGO);
    public Biome JURASSIC_LAKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_lakes"));
    public int JURASSIC_LAKES_ID =  Biome.getIdForBiome(JURASSIC_LAKES);

    private final int[] GarrigueBiomes = new int[] {
        JURASSIC_COPSE_ID,
        JURASSIC_GARRIGUE_ID,
        JURASSIC_GARRIGUE_ID,
        JURASSIC_GARRIGUE_ID,
        JURASSIC_GARRIGUE_ID,
        JURASSIC_GARRIGUE_ID,
        JURASSIC_GARRIGUE_ID,
        JURASSIC_GARRIGUE_ID,
        JURASSIC_GARRIGUE_ID,
        JURASSIC_GARRIGUE_ID,
        JURASSIC_GARRIGUE_ID,
        JURASSIC_GARRIGUE_ID,
        JURASSIC_GARRIGUE_ID
    };

    private final int[] GinkgoBiomes = new int[] {
            JURASSIC_LAKES_ID,
            JURASSIC_GINKGO_ID,
            JURASSIC_GINKGO_ID,
            JURASSIC_GINKGO_ID,
            JURASSIC_GINKGO_ID
    };

    public GenLayerDiversifyJurassic3(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        return diversify(x, z, width, height);
    }

    private int[] diversify(int x, int z, int width, int height) {
        int[] input = this.parent.getInts(x, z, width, height);
        int[] output = IntCache.getIntCache(width * height);
        EnumBiomeTypePermian type;
        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                if (nextInt(2) == 0) {
                    if (Biome.getBiome(center) == BiomeJurassicGarrigue.biome) {
                        output[i] = GarrigueBiomes[nextInt(GarrigueBiomes.length)];
                    }
                    else if (Biome.getBiome(center) == BiomeJurassicGinkgoWoodland.biome) {
                        output[i] = GinkgoBiomes[nextInt(GinkgoBiomes.length)];
                    }
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}