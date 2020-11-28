package put.io.patterns.implement;

public class SystemInfoObserver implements SystemStateObserver{
    public void update(SystemMonitor monitor){
        SystemState lastSystemState = monitor.getLastSystemState();
        System.out.println("============================================");
        System.out.println(String.format("CPU Load: %2.2f%%", lastSystemState.getCpu()));
        System.out.println(String.format("CPU temperature: %.2f C", lastSystemState.getCpuTemp()));
        System.out.println(String.format("Available memory: %.2f MB", lastSystemState.getAvailableMemory()));
        System.out.println(String.format("USB devices: %d", lastSystemState.getUsbDevices()));




    }
}
