
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
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeJurassicIslandLargeRim extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:jurassic_island_large")
	public static final BiomeGenCustom biome = null;
	public BiomeJurassicIslandLargeRim(ElementsLepidodendronMod instance) {
		super(instance, 1589);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.LUSH);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.JUNGLE);
	}

	static class BiomeGenCustom extends BiomeJurassic {
		public BiomeGenCustom() {
			super(new BiomeProperties("Jurassic Caldera Island Cliffs").setBaseHeight(3.5F).setHeightVariation(0.5F).setTemperature(2.0F).setRainfall(0.8F));
			setRegistryName("lepidodendron:jurassic_island_large");
			topBlock = Blocks.DIRT.getStateFromMeta(1);
			fillerBlock = Blocks.STONE.getDefaultState();
			decorator.treesPerChunk = 2;
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

		@Override
		@SideOnly(Side.CLIENT)
		public int getFoliageColorAtPos(BlockPos pos)
		{
			return -9587179 ;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public int getGrassColorAtPos(BlockPos pos)
		{
			return -9587179 ;
		}

		@Override
		public int getModdedBiomeGrassColor(int original)
		{
			return -9587179 ;
		}

		@Override
		public int getModdedBiomeFoliageColor(int original)
		{
			return -9587179 ;
		}

		protected static final WorldGenNullTree NULL_TREE = new WorldGenNullTree(false);
		protected static final WorldGenMonkeyPuzzleAraucariaTree PARARAUCARIA_TREE = new WorldGenMonkeyPuzzleAraucariaTree(false);
		protected static final WorldGenAraucaritesTree ARAUCARITES_TREE = new WorldGenAraucaritesTree(false);
		protected static final WorldGenBushyAraucariaTree BUSHY_ARAUCARUA_TREE = new WorldGenBushyAraucariaTree(false);

		protected static final WorldGenSelaginella SELAGINELLA_GENERATOR = new WorldGenSelaginella();
		protected static final WorldGenTreeLog LOG_GENERATOR = new WorldGenTreeLog(BlockDeadLog.block);
		protected static final WorldGenLeafblock LEAVES_GENERATOR = new WorldGenLeafblock();
		protected static final WorldGenGrassyHorsetail GRASS_GENERATOR = new WorldGenGrassyHorsetail();
		protected static final WorldGenAridHorsetail ARID_HORSETAIL_GENERATOR = new WorldGenAridHorsetail();
		protected static final WorldGenZamites ZAMITES_GENERATOR = new WorldGenZamites();
		protected static final WorldGenZamitesShoot ZAMITES_SHOOT_GENERATOR = new WorldGenZamitesShoot();
		protected static final WorldGenCycadeoidea CYCADEOIDEA_GENERATOR = new WorldGenCycadeoidea();
		protected static final WorldGenBaiera BAIERA_GENERATOR = new WorldGenBaiera();
		protected static final WorldGenOtozamites OTOZAMITES_GENERATOR = new WorldGenOtozamites();
		protected static final WorldGenFurcifolium FURCIFOLIUM_GENERATOR = new WorldGenFurcifolium();

		protected static final WorldGenPuddles PUDDLES_GENERATOR = new WorldGenPuddles();
		protected static final WorldGenShellyReefSubmerged EXPOSED_REEF_GENERATOR = new WorldGenShellyReefSubmerged();
		protected static final WorldGenCorallineAlgae CORALLINE_GENERATOR = new WorldGenCorallineAlgae();
		protected static final WorldGenPrehistoricGroundCoverSandy GROUNDCOVER_GENERATOR = new WorldGenPrehistoricGroundCoverSandy();
		protected static final WorldGenHermanophyton HERMANOPHYTON_GENERATOR = new WorldGenHermanophyton();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
		{
			if (rand.nextInt(5) != 0) {
				return NULL_TREE;
			}
			else if (rand.nextInt(3) == 0) {
				return PARARAUCARIA_TREE;
			}
			else if (rand.nextInt(5) == 0) {
				return ARAUCARITES_TREE;
			}
			return BUSHY_ARAUCARUA_TREE;
		}

		@Override
		public void decorate(World worldIn, Random rand, BlockPos pos) {

//			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
//				int i = rand.nextInt(5);
//
//				for (int j = 0; j < i; ++j) {
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(16) + 8;
//					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
//					if (Math.random() > 0.8) {
//						LOG_GENERATOR.generate(worldIn, rand, blockpos);
//					}
//				}
//			}
//
//			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 2; ++i) {
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					PUDDLES_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
//				}
//
//			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 64; ++i) {
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					EXPOSED_REEF_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
//				}
//
//			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 36; ++i) {
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					CORALLINE_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
//				}
//
			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					LEAVES_GENERATOR.generate((BlockBush) BlockSphenobaieraSapling.block, BlockSphenobaieraLeaves.block.getDefaultState(), BlockSphenobaieraLog.block.getDefaultState().withProperty(BlockSphenobaieraLog.BlockCustom.FACING, EnumFacing.NORTH), worldIn, rand, pos.add(j, l, k), 70, 120);
				}
//
			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					LEAVES_GENERATOR.generate((BlockBush) BlockBrachyphyllumSapling.block, BlockBrachyphyllumLeaves.block.getDefaultState(), BlockBrachyphyllumLog.block.getDefaultState().withProperty(BlockBrachyphyllumLog.BlockCustom.FACING, EnumFacing.NORTH), worldIn, rand, pos.add(j, l, k), 70, 120);
				}
//
//			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 48; ++i) {
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					LEAVES_GENERATOR.generate((BlockBush) BlockHirmeriellaSapling.block, BlockHirmeriellaLeaves.block.getDefaultState(), BlockHirmeriellaLog.block.getDefaultState().withProperty(BlockBrachyphyllumLog.BlockCustom.FACING, EnumFacing.NORTH), worldIn, rand, pos.add(j, l, k), 63, 90);
//				}
//
//			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 56; ++i) {
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					SELAGINELLA_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
//				}
//
//			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 48; ++i) {
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					ARID_HORSETAIL_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
//				}
//
//			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 8; ++i) {
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					FURCIFOLIUM_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
//				}
//
//			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 36; ++i) {
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					GROUNDCOVER_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
//				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 4; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					HERMANOPHYTON_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), false);
				}

			super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypeJurassic getBiomeType() {
			return EnumBiomeTypeJurassic.IslandRock;
		}

	}

}
