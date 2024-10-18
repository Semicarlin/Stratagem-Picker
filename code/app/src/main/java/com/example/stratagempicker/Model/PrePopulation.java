package com.example.stratagempicker.Model;

public class PrePopulation {

    private String tableName = "stratagems";

    private int stratagemCount = 54;

	private String[] stratagemStrings = {
		"INSERT INTO " + tableName + " VALUES('0', 'Machine Gun', 'dldur', 3, 1e999, 480, weapon, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('1', 'Anti-Material Rifle', 'dlrud', 3, 1e999, 480, weapon, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('2', 'Stalwart', 'dlduul', 3, 1e999, 480, weapon, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('3', 'Expendable Anti-Tank', 'ddlur', 2, 1e999, 70, weapon, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('4', 'Recoilless Rifle', 'dlrrl', 3, 1e999, 480, weapon, 1, 1);",
		"INSERT INTO " + tableName + " VALUES('5', 'Flamethrower', 'dludu', 3, 1e999, 480, weapon, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('6', 'Autocannon', 'dlduur', 3, 1e999, 480, weapon, 1, 1);",
		"INSERT INTO " + tableName + " VALUES('7', 'Railgun', 'drdulr', 3, 1e999, 480, weapon, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('8', 'Spear', 'ddudd', 3, 1e999, 480, weapon, 1, 1);",
		"INSERT INTO " + tableName + " VALUES('9', 'Orbital Gatling Barrage', 'rdluu', 2, 1e999, 80, orbital, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('10', 'Orbital Airburst Strike', 'rrr', 2, 1e999, 120, orbital, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('11', 'Orbital 120mm HE Barrage', 'rrdlrd', 5, 1e999, 240, orbital, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('12', 'Orbital 380mm HE Barrage', 'rduuldd', 6, 1e999, 240, orbital, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('13', 'Orbital Walking Barrage', 'rdrdrd', 3, 1e999, 240, orbital, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('14', 'Orbital Laser Strike', 'rdurd', 2, 3, 300, orbital, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('15', 'Orbital Railcannon Strike', 'ruddr', 1, 1e999, 210, orbital, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('16', 'Eagle Strafing Run', 'urr', 0, 4, 8, eagle, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('17', 'Eagle Airstrike', 'urdr', 0, 2, 8, eagle, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('18', 'Eagle Cluster Bomb', 'urddr', 0, 4, 8, eagle, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('19', 'Eagle Napalm Airstrike', 'urdu', 0, 2, 8, eagle, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('20', 'Jump Pack', 'duudu', 5, 1e999, 480, backpack, 1, 1);",
		"INSERT INTO " + tableName + " VALUES('21', 'Eagle Smoke Strike', 'urud', 0, 2, 8, eagle, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('22', 'Eagle 110mm Rocket Pods', 'urul', 0, 2, 8, eagle, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('23', 'Eagle 500kg Bomb', 'urddd', 0, 1, 8, eagle, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('24', 'Orbital Precision Strike', 'rru', 4, 1e999, 100, orbital, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('25', 'Orbital Gas Strike', 'rrdr', 2, 1e999, 75, orbital, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('26', 'Orbital EMS Strike', 'rrld', 2, 1e999, 75, orbital, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('27', 'Orbital Smoke Strike', 'rrdu', 2, 1e999, 100, orbital, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('28', 'HMG Emplacement', 'dulrrl', 3, 1e999, 180, emplacement, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('29', 'Shield Generator Relay', 'ddlrlr', 0, 1e999, 90, emplacement, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('30', 'Tesla Tower', 'durulr', 3, 1e999, 150, emplacement, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('31', 'Anti-Personnel Minefield', 'dldur', 3, 1e999, 180, emplacement, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('32', 'Supply Pack', 'dlduud', 5, 1e999, 480, backpack, 1, 1);",
		"INSERT INTO " + tableName + " VALUES('33', 'Grenade Launcher', 'dluld', 3, 1e999, 480, weapon, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('34', 'Laser Cannon', 'dldul', 3, 1e999, 480, weapon, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('35', 'Incendiary Mines', 'dlld', 3, 1e999, 180, emplacement, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('36', 'Guard Dog Rover', 'dulurr', 5, 1e999, 480, backpack, 1, 1);",
		"INSERT INTO " + tableName + " VALUES('37', 'Ballistic Shield Backpack', 'dlddul', 5, 1e999, 300, backpack, 1, 1);",
		"INSERT INTO " + tableName + " VALUES('38', 'Arc Thrower', 'drdull', 3, 1e999, 480, weapon, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('39', 'Shield Generator Pack', 'dulrlr', 5, 1e999, 480, backpack, 1, 1);",
		"INSERT INTO " + tableName + " VALUES('40', 'Machine Gun Sentry', 'durru', 3, 1e999, 180, emplacement, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('41', 'Gatling Sentry', 'durl', 3, 1e999, 180, emplacement, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('42', 'Mortar Sentry', 'durrd', 3, 1e999, 180, emplacement, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('43', 'Guard Dog', 'dulurd', 5, 1e999, 480, backpack, 1, 1);",
		"INSERT INTO " + tableName + " VALUES('44', 'Autocannon Sentry', 'durulu', 3, 1e999, 180, emplacement, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('45', 'Rocket Sentry', 'durrl', 3, 1e999, 180, emplacement, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('46', 'EMS Mortar Sentry', 'durdr', 3, 1e999, 180, emplacement, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('47', 'Patriot Exosuit', 'ldruldd', 0, 2, 600, mech, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('48', 'Airburst Rocket Launcher', 'duulr', 3, 1e999, 480, weapon, 1, 1);",
		"INSERT INTO " + tableName + " VALUES('49', 'Emancipator Exosuit', 'ldruldu', 0, 2, 600, mech, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('50', 'Anti-Tank Mines', 'dluu', 7, 1e999, 180, emplacement, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('51', 'Orbital Napalm Barrage', 'rrdlru', 10, 1e999, 240, orbital, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('52', 'Sterilizer', 'dludl', 8, 1e999, 480, weapon, 0, 1);",
		"INSERT INTO " + tableName + " VALUES('53', 'Guard Dog Dog Breath', 'duluru', 10, 1e999, 480, backpack, 1, 1);"
    };

    public String[] getStratagemStrings() {
        return stratagemStrings;
    }

    public int getStratagemCount() {
        return stratagemCount;
    }
}