package put.io.patterns.implement;

public class USBDeviceObserver implements SystemStateObserver{
    private int USBCount = -1;

    public void update(SystemMonitor monitor) {
        SystemState lastSystemState = monitor.getLastSystemState();
        if (USBCount == -1){
            USBCount = lastSystemState.getUsbDevices();
        }
        else if (lastSystemState.getUsbDevices() > USBCount) {
            System.out.println("Wincyj USB");
        }
        else if (lastSystemState.getUsbDevices() < USBCount) {
            System.out.println("Mnij USB");
        }
        USBCount = lastSystemState.getUsbDevices();
    }
}















//.getUsbDevices(false).length;