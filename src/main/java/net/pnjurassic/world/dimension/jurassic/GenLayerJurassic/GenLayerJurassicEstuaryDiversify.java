package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnjurassic.world.biome.jurassic.BiomeJurassicMudflatsEstuary;

public class GenLayerJurassicEstuaryDiversify extends GenLayer {


    public Biome JURASSIC_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mudflats_estuary"));
    public int JURASSIC_ESTUARY_ID =  Biome.getIdForBiome(JURASSIC_ESTUARY);
    public Biome JURASSIC_ESTUARY_FLAT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mudflats_estuary_flat"));
    public int JURASSIC_ESTUARY_FLAT_ID =  Biome.getIdForBiome(JURASSIC_ESTUARY_FLAT);


    private final int[] EstuaryBiomes = new int[] {
            JURASSIC_ESTUARY_ID,
            JURASSIC_ESTUARY_FLAT_ID,
            JURASSIC_ESTUARY_FLAT_ID
    };

    public GenLayerJurassicEstuaryDiversify(long seed, GenLayer genlayer) {
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
                    if (Biome.getBiome(center) == BiomeJurassicMudflatsEstuary.biome)
                        output[i] = EstuaryBiomes[nextInt(EstuaryBiomes.length)];

                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}