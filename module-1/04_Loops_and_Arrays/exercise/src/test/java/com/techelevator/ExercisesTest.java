package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExercisesTest {

	private final int SMALL_CHEESE = 10;
	private final int SMALL_PEPPERONI = 11;

	private final int MEDIUM_CHEESE = 20;
	private final int MEDIUM_PEPPERONI = 21;

	private final int LARGE_CHEESE = 30;
	private final int LARGE_PEPPERONI = 31;

	private final int CALZONE = 40;
	private final int SPAGHETTI_PIE = 41;
	private final int BAKED_ZITI = 42;

	private final static char SMALL_TSHIRT = 'S';
	private final static char MEDIUM_TSHIRT = 'M';
	private final static char LARGE_TSHIRT = 'L';

	@Test
	public void Exercise01_01_createOrder() {
		Exercise01_StoreOrders exercise = new Exercise01_StoreOrders();
		assertArrayEquals("createOrder()",
				new int[] {10, 40, 31, 41},
				exercise.createOrder());

	}

	@Test
	public void Exercise01_02_getCalzoneSales() {
		Exercise01_StoreOrders exercise = new Exercise01_StoreOrders();
		assertEquals("getCalzoneSales([CALZONE, SMALL_CHEESE, LARGE_CHEESE, CALZONE, SMALL_CHEESE])",
				2,
				exercise.getCalzoneSales(new int[] {CALZONE, SMALL_CHEESE, LARGE_CHEESE, CALZONE, SMALL_CHEESE}));
		assertEquals("getCalzoneSales([SMALL_CHEESE, SMALL_PEPPERONI, SMALL_CHEESE])",
				0,
				exercise.getCalzoneSales(new int[] {SMALL_CHEESE, SMALL_PEPPERONI, SMALL_CHEESE}));
		assertEquals("getCalzoneSales([])",
				0,
				exercise.getCalzoneSales(new int[] {}));
		assertEquals("getCalzoneSales([CALZONE, SMALL_CHEESE, SMALL_CHEESE])",
				1,
				exercise.getCalzoneSales(new int[] {CALZONE, SMALL_CHEESE, SMALL_CHEESE}));
		assertEquals("getCalzoneSales([SMALL_CHEESE, CALZONE, SMALL_CHEESE])",
				1,
				exercise.getCalzoneSales(new int[] {SMALL_CHEESE, CALZONE, SMALL_CHEESE}));
		assertEquals("getCalzoneSales([SMALL_CHEESE, SMALL_CHEESE, CALZONE])",
				1,
				exercise.getCalzoneSales(new int[] {SMALL_CHEESE, SMALL_CHEESE, CALZONE}));
		assertEquals("getCalzoneSales([CALZONE, CALZONE, SMALL_CHEESE])",
				2,
				exercise.getCalzoneSales(new int[] {CALZONE, CALZONE, SMALL_CHEESE}));
		assertEquals("getCalzoneSales([CALZONE, CALZONE, CALZONE])",
				3,
				exercise.getCalzoneSales(new int[] {CALZONE, CALZONE, CALZONE}));
	}

	@Test
	public void Exercise01_03_getCheesePizzaRevenue() {
		Exercise01_StoreOrders exercise = new Exercise01_StoreOrders();
		assertEquals("getCheesePizzaRevenue([SMALL_CHEESE])",
				8,
				exercise.getCheesePizzaRevenue(new int[] {SMALL_CHEESE}));
		assertEquals("getCheesePizzaRevenue([MEDIUM_CHEESE])",
				11,
				exercise.getCheesePizzaRevenue(new int[] {MEDIUM_CHEESE}));
		assertEquals("getCheesePizzaRevenue([LARGE_CHEESE])",
				14,
				exercise.getCheesePizzaRevenue(new int[] {LARGE_CHEESE}));
		assertEquals("getCheesePizzaRevenue([SMALL_CHEESE, SMALL_PEPPERONI, MEDIUM_CHEESE])",
				19,
				exercise.getCheesePizzaRevenue(new int[] {SMALL_CHEESE, SMALL_PEPPERONI, MEDIUM_CHEESE}));
		assertEquals("getCheesePizzaRevenue([SMALL_CHEESE, SMALL_PEPPERONI, MEDIUM_CHEESE, SMALL_PEPPERONI, LARGE_CHEESE])",
				33,
				exercise.getCheesePizzaRevenue(new int[] {SMALL_CHEESE, SMALL_PEPPERONI, MEDIUM_CHEESE, SMALL_PEPPERONI, LARGE_CHEESE}));
		assertEquals("getCheesePizzaRevenue([MEDIUM_CHEESE, SMALL_PEPPERONI, LARGE_CHEESE])",
				25,
				exercise.getCheesePizzaRevenue(new int[] {MEDIUM_CHEESE, SMALL_PEPPERONI, LARGE_CHEESE}));
		assertEquals("getCheesePizzaRevenue([SMALL_PEPPERONI, MEDIUM_PEPPERONI, LARGE_PEPPERONI])",
				0,
				exercise.getCheesePizzaRevenue(new int[] {SMALL_PEPPERONI, MEDIUM_PEPPERONI, LARGE_PEPPERONI}));
	}

	@Test
	public void Exercise02_01_generateSeatingChart() {
		Exercise02_BoardingGate exercise = new Exercise02_BoardingGate();
		assertArrayEquals("generateSeatingChart(0)",
				new boolean[] {},
				exercise.generateSeatingChart(0));
		assertArrayEquals("generateSeatingChart(1)",
				new boolean[] {true},
				exercise.generateSeatingChart(1));
		assertArrayEquals("generateSeatingChart(2)",
				new boolean[] {true, true},
				exercise.generateSeatingChart(2));
		assertArrayEquals("generateSeatingChart(3)",
				new boolean[] {true, true, true},
				exercise.generateSeatingChart(3));
		assertArrayEquals("generateSeatingChart(4)",
				new boolean[] {true, true, true,true},
				exercise.generateSeatingChart(4));
		assertArrayEquals("generateSeatingChart(5)",
				new boolean[] {true, true, true, true,true},
				exercise.generateSeatingChart(5));
	}

	@Test
	public void Exercise02_02_getAvailableSeatCount() {
		Exercise02_BoardingGate exercise = new Exercise02_BoardingGate();
		assertEquals("getAvailableSeatCount([])",
				0,
				exercise.getAvailableSeatCount(new boolean[]{}));
		assertEquals("getAvailableSeatCount([true])",
				1,
				exercise.getAvailableSeatCount(new boolean[]{true}));
		assertEquals("getAvailableSeatCount([false])",
				0,
				exercise.getAvailableSeatCount(new boolean[]{false}));
		assertEquals("getAvailableSeatCount([false, false, false, false, false, false])",
				0,
				exercise.getAvailableSeatCount(new boolean[]{false, false, false, false, false, false}));
		assertEquals("getAvailableSeatCount([true, false, false, false])",
				1,
				exercise.getAvailableSeatCount(new boolean[]{true, false, false, false}));
		assertEquals("getAvailableSeatCount([true, false, true, false])",
				2,
				exercise.getAvailableSeatCount(new boolean[]{true, false, true, false}));
		assertEquals("getAvailableSeatCount([false, true, true, false])",
				2,
				exercise.getAvailableSeatCount(new boolean[]{false, true, true, false}));
		assertEquals("getAvailableSeatCount([false, false, true, true])",
				2,
				exercise.getAvailableSeatCount(new boolean[]{false, false, true, true}));
		assertEquals("getAvailableSeatCount([true, true, true, false])",
				3,
				exercise.getAvailableSeatCount(new boolean[]{true, true, true, false}));
		assertEquals("getAvailableSeatCount([true, true, false, true])",
				3,
				exercise.getAvailableSeatCount(new boolean[]{true, true, false, true}));
		assertEquals("getAvailableSeatCount([true, false, true, true])",
				3,
				exercise.getAvailableSeatCount(new boolean[]{true, false, true, true}));
		assertEquals("getAvailableSeatCount([false, true, true, true])",
				3,
				exercise.getAvailableSeatCount(new boolean[]{false, true, true, true}));
	}

	@Test
	public void Exercise02_03_getNumberOfFullRows() {
		Exercise02_BoardingGate exercise = new Exercise02_BoardingGate();
		assertEquals("getNumberOfFullRows([])",
				0,
				exercise.getNumberOfFullRows(new boolean[]{}));
		assertEquals("getNumberOfFullRows([false, false, false, false, false, false])",
				2,
				exercise.getNumberOfFullRows(new boolean[]{false, false, false, false, false, false}));
		assertEquals("getNumberOfFullRows([false, false, false])",
				1,
				exercise.getNumberOfFullRows(new boolean[]{false, false, false}));
		assertEquals("getNumberOfFullRows([false, false, false, true, true, true])",
				1,
				exercise.getNumberOfFullRows(new boolean[]{false, false, false, true, true, true}));
		assertEquals("getNumberOfFullRows([true, true, true, true, true, true])",
				0,
				exercise.getNumberOfFullRows(new boolean[]{true, true, true, true, true, true}));
		assertEquals("getNumberOfFullRows([false, true, true, false, true, true])",
				0,
				exercise.getNumberOfFullRows(new boolean[]{false, true, true, false, true, true}));
		assertEquals("getNumberOfFullRows([true, false, true, true, false, true])",
				0,
				exercise.getNumberOfFullRows(new boolean[]{true, false, true, true, false, true}));
		assertEquals("getNumberOfFullRows([true, true, false, true, true, false])",
				0,
				exercise.getNumberOfFullRows(new boolean[]{true, true, false, true, true, false}));
		assertEquals("getNumberOfFullRows([true, false, true, false, true, false])",
				0,
				exercise.getNumberOfFullRows(new boolean[]{true, false, true, false, true, false}));
	}

	@Test
	public void Exercise03_01_buildOrder() {
		Exercise03_Shirts exercise = new Exercise03_Shirts();
		assertArrayEquals("buildOrder(()",
				new char[] {'S', 'S', 'S', 'M', 'M', 'L'},
				exercise.buildOrder());
	}

	@Test
	public void Exercise03_02_buildBulkOrder() {
		Exercise03_Shirts exercise = new Exercise03_Shirts();
		assertArrayEquals("buildBulkOrder((0)",
				new char[] {},
				exercise.buildBulkOrder(0));
		assertArrayEquals("buildBulkOrder((1)",
				new char[] {SMALL_TSHIRT},
				exercise.buildBulkOrder(1));
		assertArrayEquals("buildBulkOrder((2)",
				new char[] {SMALL_TSHIRT, MEDIUM_TSHIRT},
				exercise.buildBulkOrder(2));
		assertArrayEquals("buildBulkOrder((3)",
				new char[] {SMALL_TSHIRT, MEDIUM_TSHIRT, LARGE_TSHIRT},
				exercise.buildBulkOrder(3));
		assertArrayEquals("buildBulkOrder((4)",
				new char[] {SMALL_TSHIRT, MEDIUM_TSHIRT, LARGE_TSHIRT, SMALL_TSHIRT},
				exercise.buildBulkOrder(4));
		assertArrayEquals("buildBulkOrder((5)",
				new char[] {SMALL_TSHIRT, MEDIUM_TSHIRT, LARGE_TSHIRT, SMALL_TSHIRT, MEDIUM_TSHIRT},
				exercise.buildBulkOrder(5));
		assertArrayEquals("buildBulkOrder((6)",
				new char[] {SMALL_TSHIRT, MEDIUM_TSHIRT, LARGE_TSHIRT, SMALL_TSHIRT, MEDIUM_TSHIRT, LARGE_TSHIRT},
				exercise.buildBulkOrder(6));
	}

	@Test
	public void Exercise03_03_placeRequest() {
		Exercise03_Shirts exercise = new Exercise03_Shirts();
		assertFalse("placeRequest([])",
				exercise.placeRequest(new char[]{}));
		assertTrue("placeRequest(['S'])",
				exercise.placeRequest(new char[]{SMALL_TSHIRT}));
		assertFalse("placeRequest(['M'])",
				exercise.placeRequest(new char[]{MEDIUM_TSHIRT}));
		assertFalse("placeRequest(['L'])",
				exercise.placeRequest(new char[]{LARGE_TSHIRT}));
		assertTrue("placeRequest(['S', 'M'])",
				exercise.placeRequest(new char[]{SMALL_TSHIRT, MEDIUM_TSHIRT}));
		assertTrue("placeRequest(['M', 'S', 'L'])",
				exercise.placeRequest(new char[]{MEDIUM_TSHIRT, SMALL_TSHIRT, LARGE_TSHIRT}));
		assertFalse("placeRequest(['M', 'L'])",
				exercise.placeRequest(new char[]{MEDIUM_TSHIRT, LARGE_TSHIRT}));
		assertTrue("placeRequest(['M', 'L', 'S'])",
				exercise.placeRequest(new char[]{MEDIUM_TSHIRT, LARGE_TSHIRT, SMALL_TSHIRT}));
		assertFalse("placeRequest(['M', 'M', 'L'])",
				exercise.placeRequest(new char[]{MEDIUM_TSHIRT, MEDIUM_TSHIRT, LARGE_TSHIRT}));
	}

	@Test
	public void Exercise04_01_getFirstCard() {
		Exercise04_Cards exercise = new Exercise04_Cards();
		assertEquals("getFirstCard([\"3-H\", \"7-H\", \"5-H\", \"8-H\", \"6-H\"])",
				"3-H",
				exercise.getFirstCard(new String[] {"3-H", "7-H", "5-H", "8-H", "6-H"}));
		assertEquals("getFirstCard([\"1-C\", \"1-D\", \"1-H\", \"1-S\", \"2-C\"])",
				"1-C",
				exercise.getFirstCard(new String[] {"1-C", "1-D", "1-H", "1-S", "2-C"}));
		assertEquals("getFirstCard([\"K-C\", \"Q-D\", \"J-H\", \"10-S\", \"Q-C\"])",
				"K-C",
				exercise.getFirstCard(new String[] {"K-C", "Q-D", "J-H", "10-S", "Q-C"}));
	}

	@Test
	public void Exercise04_02_discardFirstCard() {
		Exercise04_Cards exercise = new Exercise04_Cards();
		assertArrayEquals("discardFirstCard([\"3-H\", \"7-H\", \"5-H\", \"8-H\", \"6-H\"])",
				new String[] {"7-H", "5-H", "8-H", "6-H"},
				exercise.discardFirstCard(new String[]{"3-H", "7-H", "5-H", "8-H", "6-H"}));
		assertArrayEquals("discardFirstCard([\"1-C\", \"1-D\", \"1-H\", \"1-S\", \"2-C\"])",
				new String[] {"1-D", "1-H", "1-S", "2-C"},
				exercise.discardFirstCard(new String[]{"1-C", "1-D", "1-H", "1-S", "2-C"}));
		assertArrayEquals("discardFirstCard([\"K-C\", \"Q-D\", \"J-H\", \"10-S\", \"Q-C\"])",
				new String[] {"Q-D", "J-H", "10-S", "Q-C"},
				exercise.discardFirstCard(new String[]{"K-C", "Q-D", "J-H", "10-S", "Q-C"}));
	}

	@Test
	public void Exercise04_03_discardTopCard() {
		Exercise04_Cards exercise = new Exercise04_Cards();
		assertArrayEquals("discardTopCard([\"8-D\", \"10-H\", \"J-C\", \"8-D\", \"6-S\", \"Q-C\", \"2-D\"])",
				new String[] {"10-H", "J-C", "8-D", "6-S", "Q-C", "2-D"},
				exercise.discardTopCard(new String[]{"8-D", "10-H", "J-C", "8-D", "6-S", "Q-C", "2-D"}));
		assertArrayEquals("discardTopCard([\"4-D\", \"6-S\", \"K-D\"])",
				new String[] {"6-S", "K-D"},
				exercise.discardTopCard(new String[]{"4-D", "6-S", "K-D"}));
		assertArrayEquals("discardTopCard([\"9-H\"])",
				new String[] {},
				exercise.discardTopCard(new String[]{"9-H"}));
		assertArrayEquals("discardTopCard([])",
				new String[] {},
				exercise.discardTopCard(new String[]{}));
	}

	@Test
	public void Exercise05_01_belowFreezing() {
		Exercise05_Weather exercise = new Exercise05_Weather();
		assertEquals("belowFreezing([32, 31, 30, 29, 30, 31, 32])",
				7,
				exercise.belowFreezing(new int[]{32, 31, 30, 29, 30, 31, 32}));
		assertEquals("belowFreezing([33, 30, 37, 32, 38, 31, 36])",
				3,
				exercise.belowFreezing(new int[]{33, 30, 37, 32, 38, 31, 36}));
		assertEquals("belowFreezing([33, 43, 55, 37, 44, 52, 34])",
				0,
				exercise.belowFreezing(new int[]{33, 43, 55, 37, 44, 52, 34}));
		assertEquals("belowFreezing([-7, -3, 19, 35, 30])",
				4,
				exercise.belowFreezing(new int[]{-7, -3, 19, 35, 30}));
		assertEquals("belowFreezing([33, -7, 31, -3, 34, 32])",
				4,
				exercise.belowFreezing(new int[]{33, -7, 31, -3, 34, 32}));
		assertEquals("belowFreezing([33, -11])",
				1,
				exercise.belowFreezing(new int[]{33, -11}));
		assertEquals("belowFreezing([32, 33])",
				1,
				exercise.belowFreezing(new int[]{32, 33}));
		assertEquals("belowFreezing([])",
				0,
				exercise.belowFreezing(new int[]{}));
	}

	@Test
	public void Exercise05_02_hottestDay() {
		Exercise05_Weather exercise = new Exercise05_Weather();
		assertEquals("hottestDay([81, 93, 94, 105, 99, 95, 101, 90, 89, 92])",
				105,
				exercise.hottestDay(new int[]{81, 93, 94, 105, 99, 95, 101, 90, 89, 92}));
		assertEquals("hottestDay([-7, -2, -11, -9, -4])",
				-2,
				exercise.hottestDay(new int[]{-7, -2, -11, -9, -4}));
		assertEquals("hottestDay([23, 24])",
				24,
				exercise.hottestDay(new int[]{23, 24}));
		assertEquals("hottestDay([34, 33])",
				34,
				exercise.hottestDay(new int[]{34, 33}));
		assertEquals("hottestDay([55])",
				55,
				exercise.hottestDay(new int[]{55}));
		assertEquals("hottestDay([-22])",
				-22,
				exercise.hottestDay(new int[]{-22}));
	}

	@Test
	public void Exercise05_03_fixTemperatures() {
		Exercise05_Weather exercise = new Exercise05_Weather();
		assertArrayEquals("fixTemperatures([33, 30, 32, 37, 44, 31, 41])",
				new int[]{35, 30, 34, 37, 46, 31, 43},
				exercise.fixTemperatures(new int[]{33, 30, 32, 37, 44, 31, 41}));
		assertArrayEquals("fixTemperatures([-7, -33, 19, 35])",
				new int[]{-5, -33, 21, 35},
				exercise.fixTemperatures(new int[]{-7, -33, 19, 35}));
		assertArrayEquals("fixTemperatures([-1, 0, 1])",
				new int[]{1, 0, 3},
				exercise.fixTemperatures(new int[]{-1, 0, 1}));
		assertArrayEquals("fixTemperatures([-1])",
				new int[]{1},
				exercise.fixTemperatures(new int[]{-1}));
		assertArrayEquals("fixTemperatures([])",
				new int[]{},
				exercise.fixTemperatures(new int[]{}));
	}
}
