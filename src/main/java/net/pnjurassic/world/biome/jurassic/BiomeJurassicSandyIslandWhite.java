
package net.pnjurassic.world.biome.jurassic;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.*;
import net.lepidodendron.entity.EntityPrehistoricFloraPterodactylus;
import net.lepidodendron.entity.EntityPrehistoricFloraRhamphorhynchus;
import net.lepidodendron.util.EnumBiomeTypeJurassic;
import net.lepidodendron.world.biome.ChunkGenSpawner;
import net.lepidodendron.world.biome.jurassic.BiomeJurassic;
import net.lepidodendron.world.gen.*;
import net.minecraft.block.BlockBush;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeJurassicSandyIslandWhite extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:jurassic_island_sandy_white")
	public static final BiomeGenCustom biome = null;
	public BiomeJurassicSandyIslandWhite(ElementsLepidodendronMod instance) {
		super(instance, 1589);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SANDY);
	}

	static class BiomeGenCustom extends BiomeJurassic {
		public BiomeGenCustom() {
			//was height 0.001
			super(new BiomeProperties("Jurassic Windswept Isles").setBaseHeight(-0.25F).setHeightVariation(0F).setTemperature(1.9F));
			setRegistryName("lepidodendron:jurassic_island_sandy_white");
			topBlock = BlockSandWhite.block.getDefaultState();
			fillerBlock = BlockSandstoneWhite.block.getDefaultState();
			decorator.treesPerChunk = 5;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 10;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		protected static final WorldGenNullTree NULL_TREE = new WorldGenNullTree(false);

		protected static final WorldGenSelaginella SELAGINELLA_GENERATOR = new WorldGenSelaginella();
		protected static final WorldGenTreeLog LOG_GENERATOR = new WorldGenTreeLog(BlockDeadLog.block);
		protected static final WorldGenLeafblock LEAVES_GENERATOR = new WorldGenLeafblock();
		//protected static final WorldGenGrassyHorsetail GRASS_GENERATOR = new WorldGenGrassyHorsetail();
		//protected static final WorldGenAridHorsetail ARID_HORSETAIL_GENERATOR = new WorldGenAridHorsetail();
		protected static final WorldGenZamites ZAMITES_GENERATOR = new WorldGenZamites();
		protected static final WorldGenZamitesShoot ZAMITES_SHOOT_GENERATOR = new WorldGenZamitesShoot();
		protected static final WorldGenCycadeoidea CYCADEOIDEA_GENERATOR = new WorldGenCycadeoidea();
		//protected static final WorldGenBaiera BAIERA_GENERATOR = new WorldGenBaiera();
		//protected static final WorldGenOtozamites OTOZAMITES_GENERATOR = new WorldGenOtozamites();
		//protected static final WorldGenFurcifolium FURCIFOLIUM_GENERATOR = new WorldGenFurcifolium();

		protected static final WorldGenPuddles PUDDLES_GENERATOR = new WorldGenPuddles();
		protected static final WorldGenShellyReefSubmerged EXPOSED_REEF_GENERATOR = new WorldGenShellyReefSubmerged();
		protected static final WorldGenCorallineAlgae CORALLINE_GENERATOR = new WorldGenCorallineAlgae();
		protected static final WorldGenPrehistoricGroundCoverSandy GROUNDCOVER_GENERATOR = new WorldGenPrehistoricGroundCoverSandy();

		protected static final WorldGenSinglePlantOptionalWater PLANT_GENERATOR = new WorldGenSinglePlantOptionalWater();

		protected static final WorldGenGuano GUANO_GENERATOR = new WorldGenGuano();
		protected static final WorldGenNestExtra NEST_GENERATOR = new WorldGenNestExtra();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
		{
			return NULL_TREE;
		}

		@Override
		public void decorate(World worldIn, Random rand, BlockPos pos) {

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				int i = rand.nextInt(5);

				for (int j = 0; j < i; ++j) {
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					if (Math.random() > 0.8) {
						LOG_GENERATOR.generate(worldIn, rand, blockpos);
					}
				}
			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 2; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PUDDLES_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 64; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					EXPOSED_REEF_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 36; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					CORALLINE_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 48; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					LEAVES_GENERATOR.generate((BlockBush) BlockBrachyphyllumSapling.block, BlockBrachyphyllumLeaves.block.getDefaultState(), BlockBrachyphyllumLog.block.getDefaultState().withProperty(BlockBrachyphyllumLog.BlockCustom.FACING, EnumFacing.NORTH), worldIn, rand, pos.add(j, l, k), 63, 90);
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 48; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					LEAVES_GENERATOR.generate((BlockBush) BlockHirmeriellaSapling.block, BlockHirmeriellaLeaves.block.getDefaultState(), BlockHirmeriellaLog.block.getDefaultState().withProperty(BlockBrachyphyllumLog.BlockCustom.FACING, EnumFacing.NORTH), worldIn, rand, pos.add(j, l, k), 63, 90);
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ICE)) {
				{
					//int i = rand.nextInt(32);

					for (int j = 0; j < 3; ++j)
					{
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(16) + 8;
						BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
						GUANO_GENERATOR.generate(worldIn, rand, blockpos, 62);
					}
				}
			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ICE)) {
				{
					int i = rand.nextInt(2) + 4;

					for (int j = 0; j < i; ++j)
					{
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(16) + 8;
						BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
						blockpos = ChunkGenSpawner.getTopSolidBlock(blockpos, worldIn).up();
						NEST_GENERATOR.generate(worldIn, rand, blockpos, 62, new EntityPrehistoricFloraRhamphorhynchus(worldIn));
					}

					i = rand.nextInt(2) + 4;

					for (int j = 0; j < i; ++j)
					{
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(16) + 8;
						BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
						blockpos = ChunkGenSpawner.getTopSolidBlock(blockpos, worldIn).up();
						NEST_GENERATOR.generate(worldIn, rand, blockpos, 62, new EntityPrehistoricFloraPterodactylus(worldIn));
					}

//					i = rand.nextInt(2) + 4;
//
//					for (int j = 0; j < i; ++j)
//					{
//						int k = rand.nextInt(16) + 8;
//						int l = rand.nextInt(16) + 8;
//						BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
//						blockpos = ChunkGenSpawner.getTopSolidBlock(blockpos, worldIn).up();
//						NEST_GENERATOR.generate(worldIn, rand, blockpos, 62, new EntityPrehistoricFloraPetrodactyle(worldIn));
//					}
//
//					i = rand.nextInt(2) + 4;
//
//					for (int j = 0; j < i; ++j)
//					{
//						int k = rand.nextInt(16) + 8;
//						int l = rand.nextInt(16) + 8;
//						BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
//						blockpos = ChunkGenSpawner.getTopSolidBlock(blockpos, worldIn).up();
//						NEST_GENERATOR.generate(worldIn, rand, blockpos, 62, new EntityPrehistoricFloraCampylognathoides(worldIn));
//					}
//
//					i = rand.nextInt(2) + 4;
//
//					for (int j = 0; j < i; ++j)
//					{
//						int k = rand.nextInt(16) + 8;
//						int l = rand.nextInt(16) + 8;
//						BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
//						blockpos = ChunkGenSpawner.getTopSolidBlock(blockpos, worldIn).up();
//						NEST_GENERATOR.generate(worldIn, rand, blockpos, 62, new EntityPrehistoricFloraBalaenognathus(worldIn));
//					}
//
//					i = rand.nextInt(2) + 4;
//
//					for (int j = 0; j < i; ++j)
//					{
//						int k = rand.nextInt(16) + 8;
//						int l = rand.nextInt(16) + 8;
//						BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
//						blockpos = ChunkGenSpawner.getTopSolidBlock(blockpos, worldIn).up();
//						NEST_GENERATOR.generate(worldIn, rand, blockpos, 62, new EntityPrehistoricFloraScaphognathus(worldIn));
//					}
//
//					i = rand.nextInt(2) + 4;
//
//					for (int j = 0; j < i; ++j)
//					{
//						int k = rand.nextInt(16) + 8;
//						int l = rand.nextInt(16) + 8;
//						BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
//						blockpos = ChunkGenSpawner.getTopSolidBlock(blockpos, worldIn).up();
//						NEST_GENERATOR.generate(worldIn, rand, blockpos, 62, new EntityPrehistoricFloraScaphognathus(worldIn));
//					}
				}
			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 56; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					SELAGINELLA_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 48; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockAridHorsetail.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 0, 255, true);
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 8; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockFurcifolium.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 0, 255, true);
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 36; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					GROUNDCOVER_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypeJurassic getBiomeType() {
			return EnumBiomeTypeJurassic.IslandWhite;
		}

	}

}
