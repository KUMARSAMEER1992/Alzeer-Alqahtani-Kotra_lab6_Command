package lifeform;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import environment.TestCell;
import environment.TestEnvironment;
import gameplay.TestSimpleTimer;
import recovery.TestRecoveryFractional;
import recovery.TestRecoveryLinear;
import recovery.TestRecoveryNone;
import ui.command.TesTurnNorth;
import ui.command.TestAcquire;
import ui.command.TestAttack;
import ui.command.TestDrop;
import ui.command.TestInvokerBuilder;
import ui.command.TestMove;
import ui.command.TestReload;
import ui.command.TestTurnEast;
import ui.command.TestTurnSouth;
import ui.command.TestTurnWest;
import weapon.TestAttachment;
import weapon.TestChainGun;
import weapon.TestGenericWeapon;
import weapon.TestPistol;
import weapon.TestPlasmaCannon;
import weapon.TestPowerBooster;
import weapon.TestScope;
import weapon.TestStabilizer;

/**
 * Test Suit contains all Test Classes.
 * @author Sameer Kumar Kotra
 */
@RunWith(Suite.class)
@SuiteClasses(
{ TestAlien.class, TestHuman.class, TestLifeForm.class, TestCell.class, TestEnvironment.class, TestSimpleTimer.class,
		TestRecoveryFractional.class, TestRecoveryLinear.class, TestRecoveryNone.class, TestAttachment.class,
		TestChainGun.class, TestGenericWeapon.class, TestPistol.class, TestPlasmaCannon.class, TestPowerBooster.class,
		TestScope.class, TestStabilizer.class, TestAcquire.class, TestAttack.class, TestDrop.class,
		TestInvokerBuilder.class, TestMove.class, TestReload.class, TestTurnEast.class, TestTurnSouth.class,
		TestTurnWest.class, TesTurnNorth.class })
public class AllGameTests
{

}
