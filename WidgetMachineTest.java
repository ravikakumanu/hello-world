package test.com.lloydsbanking;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.lloydsbanking.interview.EngineType;
import com.lloydsbanking.interview.FuelType;
import com.lloydsbanking.interview.WidgetMachine;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WidgetMachineTest {
	private double cost=0.00;

	@Test(expected = IllegalStateException.class)
	public void test01ProduceWidgetsWithDefaultEngineWithNoFuel() {
		WidgetMachine wMachine = new WidgetMachine();
		cost = wMachine.produceWidgets(40);
		
	}

	@Test(expected = IllegalStateException.class)
	public void test02ProduceWidgetsWithDefaultEngineWithZeroFuel() {
		WidgetMachine wMachine = new WidgetMachine();
		wMachine.loadEngineTypeAndFuelValues(null, null, 0);
		cost = wMachine.produceWidgets(40);
	}

	@Test
	public void test03ProduceWidgetsWithDefaultEngineWithExcessiveFuel() {
		WidgetMachine wMachine = new WidgetMachine();
		wMachine.loadEngineTypeAndFuelValues(null, null, 1200);
		cost = wMachine.produceWidgets(40);
		assertEquals(45.00, cost, 1);
		System.out.println("cost value: "+cost);
	}

	@Test(expected = IllegalStateException.class)
	public void test04ProduceWidgetsWithCombustionEngineAndDefalutFuelWithNegativeLevel() {
		WidgetMachine wMachine = new WidgetMachine();
		wMachine.loadEngineTypeAndFuelValues(EngineType.COMBUSTION, null, -100);
		cost = wMachine.produceWidgets(40);
	}

	@Test
	public void test05ProduceWidgetsWithCombustionEngineAndPetrol() {
		WidgetMachine wMachine = new WidgetMachine();
		wMachine.loadEngineTypeAndFuelValues(EngineType.COMBUSTION, FuelType.PETROL, 50);
		cost = wMachine.produceWidgets(40);
		assertEquals(45.00, cost, 1);
	}

	@Test
	public void test06ProduceWidgetsWithCombustionEngineAndDiesel() {
		WidgetMachine wMachine = new WidgetMachine();
		wMachine.loadEngineTypeAndFuelValues(EngineType.COMBUSTION, FuelType.DIESEL, 50);
		 cost = wMachine.produceWidgets(40);
		assertEquals(60.00, cost, 1);

	}
	
	@Test(expected = IllegalStateException.class)
	public void test07ProduceWidgetsWithSteamEngineAndDefalutFuelWithNegativeLevel() {
		WidgetMachine wMachine = new WidgetMachine();
		wMachine.loadEngineTypeAndFuelValues(EngineType.STEAM, null, -100);
		cost = wMachine.produceWidgets(40);
	}
	@Test(expected = IllegalStateException.class)
	public void test08ProduceWidgetsWithSteamEngineAndDefalutFuelWithZeroFuelLevel() {
		WidgetMachine wMachine = new WidgetMachine();
		wMachine.loadEngineTypeAndFuelValues(EngineType.STEAM, null, 0);
		cost = wMachine.produceWidgets(40);
	}
	@Test(expected = IllegalStateException.class)
	public void test09ProduceWidgetsWithSteamEngineAndPetrolFuelWithFuelLevel() {
		WidgetMachine wMachine = new WidgetMachine();
		wMachine.loadEngineTypeAndFuelValues(EngineType.STEAM, FuelType.PETROL, 100);
		cost = wMachine.produceWidgets(40);
	}
	@Test(expected = IllegalStateException.class)
	public void test10ProduceWidgetsWithSteamEngineAndDieselFuelWithFuelLevel() {
		WidgetMachine wMachine = new WidgetMachine();
		wMachine.loadEngineTypeAndFuelValues(EngineType.STEAM, FuelType.DIESEL, 100);
		cost = wMachine.produceWidgets(40);
	}
	
	@Test
	public void test11ProduceWidgetsWithSteamEngineAndDefalutFuelWithFuelLevel() {
		WidgetMachine wMachine = new WidgetMachine();
		wMachine.loadEngineTypeAndFuelValues(EngineType.STEAM, null, 100);
		cost = wMachine.produceWidgets(40);
		assertEquals(113, cost, 2);
	}
	@Test
	public void test12ProduceWidgetsWithSteamEngineAndCoalFuelWithFuelLevel() {
		WidgetMachine wMachine = new WidgetMachine();
		wMachine.loadEngineTypeAndFuelValues(EngineType.STEAM, FuelType.COAL, 100);
		cost = wMachine.produceWidgets(40);
		assertEquals(113, cost, 2);
	}
	@Test
	public void test13ProduceWidgetsWithSteamEngineAndWoodFuelWithFuelLevel() {
		WidgetMachine wMachine = new WidgetMachine();
		wMachine.loadEngineTypeAndFuelValues(EngineType.STEAM, FuelType.WOOD, 100);
		 cost = wMachine.produceWidgets(40);
		assertEquals(87, cost, 2);
	}
}
