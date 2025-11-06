
package net.pnjurassic.world.biome.jurassic;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.*;
import net.lepidodendron.util.EnumBiomeTypeJurassic;
import net.lepidodendron.world.biome.jurassic.BiomeJurassic;
import net.lepidodendron.world.gen.*;
import net.minecraft.block.BlockBush;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeJurassicMudflatsEstuaryCopse extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:jurassic_mudflats_estuary_copse")
	public static final BiomeGenCustom biome = null;
	public BiomeJurassicMudflatsEstuaryCopse(ElementsLepidodendronMod instance) {
		super(instance, 1589);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.FOREST);
	}

	static class BiomeGenCustom extends BiomeJurassic {
		public BiomeGenCustom() {
			//was height 0.001
			super(new BiomeProperties("Jurassic Alluvial Grove").setBaseHeight(0.055F).setHeightVariation(0.025F).setTemperature(1.25F).setRainfall(0.4F));
			setRegistryName("lepidodendron:jurassic_mudflats_estuary_copse");
			topBlock = BlockCoarseSiltyDirt.block.getDefaultState();
			fillerBlock = BlockBrownstone.block.getDefaultState();
			decorator.treesPerChunk = 3;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 10;
			decorator.gravelPatchesPerChunk = 10;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		protected static final WorldGenNullTree NULL_TREE = new WorldGenNullTree(false);
		protected static final WorldGenTallAraucariaTree TALL_TREE = new WorldGenTallAraucariaTree(false);
		protected static final WorldGenColumnarisTree COLUMNARIS_TREE = new WorldGenColumnarisTree(false);
		protected static final WorldGenGinkgoTree GINKGO_TREE = new WorldGenGinkgoTree(false);
		protected static final WorldGenAraucaritesTree ARAUCARITES_TREE = new WorldGenAraucaritesTree(false);
		protected static final WorldGenPagiophyllumTree PAGIOPHYLLUM_TREE = new WorldGenPagiophyllumTree(false);
		protected static final WorldGenKomlopteris KOMLOPTERIS_TREE = new WorldGenKomlopteris(false);

		protected static final WorldGenIsoetes ISOETES_GENERATOR = new WorldGenIsoetes();
		protected static final WorldGenAnomozamites ANOMOZAMITES_TREE = new WorldGenAnomozamites();
		protected static final WorldGenFern FERN_GENERATOR = new WorldGenFern();
		protected static final WorldGenWaterHorsetail WATER_HORSETAIL_GENERATOR = new WorldGenWaterHorsetail();
		protected static final WorldGenLeafblock LEAVES_GENERATOR = new WorldGenLeafblock();
		protected static final WorldGenSelaginella SELAGINELLA_GENERATOR = new WorldGenSelaginella();
		protected static final WorldGenTreeLog LOG_GENERATOR = new WorldGenTreeLog(BlockCzekanowskiaLog.block);
		protected static final WorldGenGravelPatch SAND_PATCH_GENERATOR = new WorldGenGravelPatch(Blocks.GRAVEL, 8);

		protected static final WorldGenCzekanowskia CZEKANOWSKIA_GENERATOR = new WorldGenCzekanowskia();

		protected static final WorldGenWaterSideSandyPrehistoricGround WATERSIDE_DIRT_GENERATOR = new WorldGenWaterSideSandyPrehistoricGround();
		protected static final WorldGenWatersideMud WATERSIDE_MUD_GENERATOR = new WorldGenWatersideMud();

		protected static final WorldGenPuddles PUDDLES_GENERATOR = new WorldGenPuddles();
		protected static final WorldGenRedSandyDirt DIRT_GENERATOR = new WorldGenRedSandyDirt();
		protected static final WorldGenDriedMud MUD_GENERATOR = new WorldGenDriedMud();
		protected static final WorldGenSlimyAlgae SLIMY_GENERATOR = new WorldGenSlimyAlgae();
		protected static final WorldGenSinglePlantOptionalWater PLANT_GENERATOR = new WorldGenSinglePlantOptionalWater();
		protected static final WorldGenSingleStaticInWaterUpwards STATIC_GENERATOR = new WorldGenSingleStaticInWaterUpwards();
		protected static final WorldGenSingleStaticInWaterRotational STATIC_ROTATIONAL_GENERATOR = new WorldGenSingleStaticInWaterRotational();
		protected static final WorldGenSingleStaticInWaterSideways STATIC_SIDEWAYS_GENERATOR = new WorldGenSingleStaticInWaterSideways();
		protected static final WorldGenSingleStaticInWaterColumn STATIC_COLUMN_GENERATOR = new WorldGenSingleStaticInWaterColumn();
		protected static final WorldGenSingleAnemoneSea ANEMONE_GENERATOR = new WorldGenSingleAnemoneSea();
		protected static final WorldGenSingleSponge SPONGE_GENERATOR = new WorldGenSingleSponge();
		protected static final WorldGenSingleSpongeSideways SPONGE_SIDEWAYS_GENERATOR = new WorldGenSingleSpongeSideways();
		protected static final WorldGenSingleCoral CORAL_GENERATOR = new WorldGenSingleCoral();
		protected static final WorldGenSingleCoralSideways CORAL_SIDEWAYS_GENERATOR = new WorldGenSingleCoralSideways();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
		{
			if (rand.nextInt(8) != 0) {
				if (rand.nextInt(4) == 0) {
					return KOMLOPTERIS_TREE;
				}
				return NULL_TREE;
			}
			if (rand.nextInt(3) != 0) {
				return COLUMNARIS_TREE;
			}
			if (rand.nextInt(3) != 0) {
				return GINKGO_TREE;
			}
			if (rand.nextInt(3) != 0) {
				return ARAUCARITES_TREE;
			}
			if (rand.nextInt(3) != 0) {
				return PAGIOPHYLLUM_TREE;
			}
			return TALL_TREE;
		}

		@Override
		public void decorate(World worldIn, Random rand, BlockPos pos)
		{
			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 4; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					LEAVES_GENERATOR.generate((BlockBush) BlockGinkgoSapling.block, BlockGinkgoLeaves.block.getDefaultState(), BlockGinkgoLog.block.getDefaultState().withProperty(BlockGinkgoLog.BlockCustom.FACING, EnumFacing.NORTH), worldIn, rand, pos.add(j, l, k), 0, 90);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 4; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					LEAVES_GENERATOR.generate((BlockBush) BlockSphenobaieraSapling.block, BlockSphenobaieraLeaves.block.getDefaultState(), BlockSphenobaieraLog.block.getDefaultState().withProperty(BlockSphenobaieraLog.BlockCustom.FACING, EnumFacing.NORTH), worldIn, rand, pos.add(j, l, k), 0, 90);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
			for (int i = 0; i < 3; ++i)
			{
				int j = rand.nextInt(16) + 8;
				int k = rand.nextInt(16) + 8;
				int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
				CZEKANOWSKIA_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), true);
			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				int i = rand.nextInt(2);

				for (int j = 0; j < i; ++j) {
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					if (Math.random() > 0.8) {
						LOG_GENERATOR.generate(worldIn, rand, blockpos);
					}
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 1; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PUDDLES_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 32; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					WATERSIDE_DIRT_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 92; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					WATERSIDE_MUD_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 28; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					MUD_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), false);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 3; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					ANOMOZAMITES_TREE.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 28; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					FERN_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), 67, 90);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockPalissya.block.getDefaultState(), worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockPelourdea.block.getDefaultState(), worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockToditesShootPlaceable.block.getDefaultState(), worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 36; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockClaytosmunda.block.getDefaultState(), worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockConiopteris.block.getDefaultState(), worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					SELAGINELLA_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 48; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					ISOETES_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 32; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					WATER_HORSETAIL_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 156; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockGrassyHorsetail.block.getDefaultState(), worldIn, rand, pos.add(j, l, k));
				}


			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 80; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					SLIMY_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}






			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 8; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					STATIC_COLUMN_GENERATOR.generate(BlockGreenStemmedAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 20, 0, 255, 4);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 17; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockGreenLeafyAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 36; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockGreenAlgaeMat.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 22; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockPiledAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 12; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockGreenSproutingAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 22; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockStalkedAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 64; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockGreenCharaAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 22; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockGreenCrustedAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 22; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_SIDEWAYS_GENERATOR.generate(BlockGreenCrustedAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 16; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_SIDEWAYS_GENERATOR.generate(BlockUnderwaterDebris.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 255, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 16; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_SIDEWAYS_GENERATOR.generate(BlockUnderwaterDebris.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 255, 0, 255);
				}

			super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypeJurassic getBiomeType() {
			return EnumBiomeTypeJurassic.Mudflats;
		}

	}

}
