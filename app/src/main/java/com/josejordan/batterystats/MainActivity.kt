package com.josejordan.batterystats

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.josejordan.batterystats.databinding.ActivityMainBinding


/*class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
            this.registerReceiver(null, ifilter)
        }

        batteryStatus?.let { intent ->
            val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val batteryPct: Float = level / scale.toFloat()

            val status: Int = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
            val isCharging: Boolean = status == BatteryManager.BATTERY_STATUS_CHARGING
                    || status == BatteryManager.BATTERY_STATUS_FULL

            val chargePlug: Int = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
            val usbCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_USB
            val acCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_AC
            val wirelessCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_WIRELESS

            val temperature: Int = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1)

            val technology: String? = intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY)

            binding.batteryInfo.text = "Battery Percentage: ${(batteryPct ?: 0f) * 100}%"
            binding.chargingInfo.text = "Is Charging: $isCharging"
            binding.chargingMethodInfo.text = "Charging Method: ${if (usbCharge) "USB" else if (acCharge) "AC" else if (wirelessCharge) "Wireless" else "Not charging"}"
            binding.temperatureInfo.text = "Temperature: ${temperature / 10.0}°C"
            binding.technologyInfo.text = "Technology: $technology"
        }
    }
}*/


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
            this.registerReceiver(null, ifilter)
        }

        batteryStatus?.let { intent ->
            val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val batteryPct: Float = level / scale.toFloat()

            val status: Int = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
            val isCharging: Boolean = status == BatteryManager.BATTERY_STATUS_CHARGING
                    || status == BatteryManager.BATTERY_STATUS_FULL

            val chargePlug: Int = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
            val usbCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_USB
            val acCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_AC
            val wirelessCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_WIRELESS

            val temperature: Int = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1)

            val technology: String? = intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY)

            val voltage: Int = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1)

            val health: Int = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0)
            val healthStatus: String = when (health) {
                BatteryManager.BATTERY_HEALTH_GOOD -> "Good"
                BatteryManager.BATTERY_HEALTH_OVERHEAT -> "Overheat"
                BatteryManager.BATTERY_HEALTH_DEAD -> "Dead"
                BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> "Over Voltage"
                BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> "Failure"
                BatteryManager.BATTERY_HEALTH_COLD -> "Cold"
                else -> "Unknown"
            }

            binding.batteryInfo.text = "Battery Percentage: ${(batteryPct ?: 0f) * 100}%"
            binding.chargingInfo.text = "Is Charging: $isCharging"
            binding.chargingMethodInfo.text = "Charging Method: ${if (usbCharge) "USB" else if (acCharge) "AC" else if (wirelessCharge) "Wireless" else "Not charging"}"
            binding.temperatureInfo.text = "Temperature: ${temperature / 10.0}°C"
            binding.technologyInfo.text = "Technology: $technology"
            binding.voltageInfo.text = "Voltage: ${voltage / 1000.0}V"
            binding.healthInfo.text = "Health: $healthStatus"
        }
    }
}

