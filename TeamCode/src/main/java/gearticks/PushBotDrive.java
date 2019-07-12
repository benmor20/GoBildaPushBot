package gearticks;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class PushBotDrive extends LinearOpMode {
	private DcMotor leftMotor, rightMotor, arm;
	private static final double ARM_POWER = 1.0;

	public void runOpMode() {
		this.leftMotor = this.hardwareMap.get(DcMotor.class, "leftMotor");
		this.leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		this.rightMotor = this.hardwareMap.get(DcMotor.class, "rightMotor");
		this.rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		this.arm = this.hardwareMap.get(DcMotor.class, "arm");
		this.arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

		this.waitForStart();

		while (this.opModeIsActive()) {
			this.leftMotor.setPower(this.gamepad1.left_stick_y + this.gamepad1.right_stick_x);
			this.rightMotor.setPower(- this.gamepad1.left_stick_y + this.gamepad1.right_stick_x);
			if (this.gamepad1.y) {
				this.arm.setPower(ARM_POWER);
			} else if (this.gamepad1.a) {
				this.arm.setPower(-ARM_POWER);
			} else {
				this.arm.setPower(0.0);
			}
		}

		this.leftMotor.setPower(0.0);
		this.rightMotor.setPower(0.0);
		this.arm.setPower(0.0);
	}
}
