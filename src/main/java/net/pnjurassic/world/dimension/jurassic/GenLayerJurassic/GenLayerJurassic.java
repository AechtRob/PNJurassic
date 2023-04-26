package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.lepidodendron.LepidodendronConfig;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.*;

public class GenLayerJurassic {

    private static boolean shouldDraw = false;
    protected GenLayer parent;

    public static GenLayer[] initializeAllBiomeGenerators(long seed, WorldType worldType, String options) {

        GenLayer biomes = new GenLayerJurassicBiomes(1L);
        biomes = new GenLayerFuzzyZoom(2000L, biomes);
        if (!LepidodendronConfig.doShrinkBiomes) {
            biomes = new GenLayerZoom(2001L, biomes);
        }
        biomes = new GenLayerDiversifyJurassic(1000L, biomes);
        biomes = new GenLayerDiversifyJurassicSandbanks(50L, biomes);

        biomes = new GenLayerZoom(1000L, biomes);
        biomes = new GenLayerDiversifyJurassic2(1001L, biomes);
        biomes = new GenLayerDiversifyJurassicMudflats(1133L, biomes);
        biomes = new GenLayerDiversifyJurassicSandbanks(50L, biomes);

        biomes = new GenLayerJurassicEstuary1(1008L, biomes);

        biomes = new GenLayerZoom(1001L, biomes);

        biomes = new GenLayerAddHillsToRedwood(1001L, biomes);

        biomes = new GenLayerDiversifyJurassic2(1002L, biomes);
        biomes = new GenLayerDiversifyJurassicMudflats(1134L, biomes);
        biomes = new GenLayerJurassicDeepOcean(1100L, biomes);
        biomes = new GenLayerJurassicShallowOcean(1300L, biomes);
        biomes = new GenLayerJurassicOutcropHighlands(1075L, biomes);

        biomes = new GenLayerJurassicEstuary2(1000L, biomes);

        biomes = new GenLayerJurassicGlassSpongeReef(1985L, biomes);
        biomes = new GenLayerDiversifyJurassic2point5(1009L, biomes);
        biomes = new GenLayerJurassicRafts(1429L, biomes);

        biomes = new GenLayerZoom(1003L, biomes);

        biomes = new GenLayerJurassicEstuary2(1000L, biomes);

        biomes = new GenLayerDiversifyJurassicSandbanks3(1333L, biomes);

        biomes = new GenLayerDiversifyJurassicMudflats(1135L, biomes);
        biomes = new GenLayerSmooth(700L, biomes);
        biomes = new GenLayerSmooth(701L, biomes);
        biomes = new GenLayerJurassicOutcrop(1088L, biomes);
        biomes = new GenLayerJurassicCoral(439L, biomes);
        biomes = new GenLayerZoom(1004L, biomes);

        biomes = new GenLayerAddMountainsToRedwoodRare(1001L, biomes);
        biomes = new GenLayerDiversifyJurassicSandbanks3(1333L, biomes);

        biomes = new GenLayerJurassicEstuary2(1000L, biomes);

        biomes = new GenLayerJurassicOutcropBlend(1088L, biomes);
        biomes = new GenLayerSmooth(703L, biomes);
        biomes = new GenLayerJurassicBoulders(1066L, biomes);
        biomes = new GenLayerDiversifyJurassic3(1001L, biomes);
        //biomes = new GenLayerJurassicCoral(438L, biomes);
        biomes = new GenLayerFuzzyZoom(1000L, biomes);

        biomes = new GenLayerAddMountainsToRedwood(1001L, biomes);
        biomes = new GenLayerRandomiseRedwood(1001L, biomes);

        biomes = new GenLayerJurassicBoulders(1067L, biomes);
        biomes = new GenLayerJurassicBeach(1050L, biomes);
        biomes = new GenLayerJurassicOutcropBlend2(333L, biomes);
        biomes = new GenLayerDiversifyJurassicMudflats(1136L, biomes);
        biomes = new GenLayerSmooth(705L, biomes);
        biomes = new GenLayerFuzzyZoom(1001L, biomes);
        biomes = new GenLayerDiversifyJurassicMudflats(1137L, biomes);

        biomes = new GenLayerSmooth(706L, biomes);
        biomes = new GenLayerJurassicRiverBorder(325L, biomes);
        biomes = new GenLayerJurassicRiverBanks(225L, biomes);
        biomes = new GenLayerJurassicLakeShore(625L, biomes);
        biomes = new GenLayerJoinRiversJurassic(150L, biomes);
        biomes = new GenLayerJoinRiversJurassic(151L, biomes);
        biomes = new GenLayerJoinRiversJurassic(152L, biomes);

        biomes = new GenLayerJurassicTryToJoinRiverToSea(1000L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1001L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1002L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1003L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1004L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1005L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1006L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1007L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1008L, biomes);

        biomes = new GenLayerJurassicTaigaBasalt(1975L, biomes);
        biomes = new GenLayerFuzzyZoom(1002L, biomes);

        biomes = new GenLayerJurassicTryToJoinRiverToSea(1000L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1001L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1002L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1003L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1004L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1005L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1006L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1007L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1008L, biomes);

        biomes = new GenLayerDiversifyJurassicMudflats(1138L, biomes);
        biomes = new GenLayerJurassicRiverBorder(326L, biomes);
        biomes = new GenLayerJurassicRiverBorderMudflats(326L, biomes);
        biomes = new GenLayerJurassicRiverBorderMire(328L, biomes);

        biomes = new GenLayerJurassicTryToJoinRiverToSea(1000L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1001L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1002L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1003L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1004L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1005L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1006L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1007L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1008L, biomes);

        biomes = new GenLayerJurassicRiverBanks(226L, biomes);
        biomes = new GenLayerSmooth(719L, biomes); //ADDED THIS
        biomes = new GenLayerJoinRiversJurassic(153L, biomes);
        biomes = new GenLayerJoinRiversJurassic(154L, biomes);
        biomes = new GenLayerJoinRiversJurassic(155L, biomes);
        biomes = new GenLayerJoinRiversJurassic(156L, biomes);
        biomes = new GenLayerJurassicRiverBanks(227L, biomes);
        biomes = new GenLayerJurassicTaigaBasalt(1976L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1000L, biomes);
        biomes = new GenLayerZoom(1006L, biomes);

        biomes = new GenLayerJurassicTryToJoinRiverToSea(1000L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1001L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1002L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1003L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1004L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1005L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1006L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1007L, biomes);
        biomes = new GenLayerJurassicTryToJoinRiverToSea(1008L, biomes);

        //Build and superimpose creeks:
        GenLayer genlayercreek = new GenLayerRiverInit(100L, biomes);
        GenLayer genlayercreek2 = GenLayerZoom.magnify(1000L, genlayercreek, 2);
        GenLayer genlayercreek3 = GenLayerZoom.magnify(1000L, genlayercreek2, 2);
        GenLayer genlayercreek4 = GenLayerZoom.magnify(1000L, genlayercreek3, 2);
        GenLayer genlayercreek5 = GenLayerZoom.magnify(1000L, genlayercreek4, 1);
        GenLayer genlayercreek6 = new GenLayerRiver(1L, genlayercreek5);
        GenLayer genlayercreek7 = new GenLayerSmooth(1000L, genlayercreek6);
        GenLayer genlayercreekfinal = new GenLayerJurassicRiverMix(100L, biomes, genlayercreek7);

        GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, genlayercreekfinal);

        genlayercreekfinal.initWorldGenSeed(seed);
        genlayervoronoizoom.initWorldGenSeed(seed);
        biomes.initWorldGenSeed(seed);

        genlayervoronoizoom.initWorldGenSeed(seed);
        return (new GenLayer[] { genlayercreekfinal, genlayervoronoizoom, genlayercreekfinal });
    }

}