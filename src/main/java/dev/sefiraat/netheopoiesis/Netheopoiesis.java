package dev.sefiraat.netheopoiesis;

import dev.sefiraat.netheopoiesis.api.plant.netheos.NetheoBalls;
import dev.sefiraat.netheopoiesis.implementation.Items;
import dev.sefiraat.netheopoiesis.managers.ConfigManager;
import dev.sefiraat.netheopoiesis.managers.DispatchManager;
import dev.sefiraat.netheopoiesis.managers.ListenerManager;
import dev.sefiraat.netheopoiesis.managers.MobManager;
import dev.sefiraat.netheopoiesis.managers.SupportedPluginManager;
import dev.sefiraat.netheopoiesis.managers.TaskManager;
import com.github.drakescraft_labs.slimefun4.api.SlimefunAddon;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.text.MessageFormat;

public class Netheopoiesis extends JavaPlugin implements SlimefunAddon {
    // Todo replace with config
    public static final int CRUX_SPREAD_MULTIPLIER = 1;
    public static final int CRYSTALLINE_SPREAD_MULTIPLIER = 1;
    public static final int GROWTH_RATE_MULTIPLIER = 1;

    private static Netheopoiesis instance;

    private final String username;
    private final String repo;
    private final String branch;

    private ConfigManager configManager;
    private SupportedPluginManager supportedPluginManager;
    private ListenerManager listenerManager;
    private TaskManager taskManager;
    private MobManager mobManager;
    private DispatchManager dispatchManager;
    private Purification purification;
    private Registry registry;

    public Netheopoiesis() {
        this.username = "SlimefunNewHorizons";
        this.repo = "Netheopoiesis";
        this.branch = "main";
    }

    @Override
    public void onEnable() {
        instance = this;

        getLogger().info("########################################");
        getLogger().info("    Netheopoiesis by Sefiraat, J3fftw   ");
        getLogger().info("########################################");

        saveDefaultConfig();
        this.configManager = new ConfigManager();
        tryUpdate();

        this.supportedPluginManager = new SupportedPluginManager();
        this.listenerManager = new ListenerManager();
        this.taskManager = new TaskManager();
        this.mobManager = new MobManager();
        this.dispatchManager = new DispatchManager(this);
        this.purification = new Purification();
        this.registry = new Registry();

        Items.setup(this);
        NetheoBalls.setup();

        setupStats();
    }

    @Override
    public void onDisable() {
        this.mobManager.shutdown();
        this.configManager.saveAll();
    }

    public void tryUpdate() {
        // El autoactualizador queda desarmado a proposito en DrakesCraft.
        //
        // Este jar esta recompilado contra el Slimefun repaquetado del servidor. El que hay en el
        // GitHub de upstream apunta a los paquetes originales, asi que si el actualizador se lo
        // trajera encima, el addon dejaria de cargar.
        //
        // Se vacia el metodo en vez de apagarlo por configuracion: su condicion exige una version
        // que empiece por "DEV" y la nuestra no, pero eso es una coincidencia que se rompe el dia
        // que alguien toque la cadena de version. Se despliega por SFTP, como el resto.
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return MessageFormat.format("https://github.com/{0}/{1}/issues/", this.username, this.repo);
    }

    private void setupStats() {
    }

    public static Netheopoiesis getInstance() {
        return Netheopoiesis.instance;
    }

    public static void logError(@Nonnull String string) {
        instance.getLogger().severe(string);
    }

    public static void logWarning(@Nonnull String string) {
        instance.getLogger().warning(string);
    }

    public static void logInfo(@Nonnull String string) {
        instance.getLogger().info(string);
    }

    @Nonnull
    public static PluginManager getPluginManager() {
        return Netheopoiesis.getInstance().getServer().getPluginManager();
    }

    public static ConfigManager getConfigManager() {
        return Netheopoiesis.getInstance().configManager;
    }

    public static SupportedPluginManager getSupportedPluginManager() {
        return Netheopoiesis.getInstance().supportedPluginManager;
    }

    public static ListenerManager getListenerManager() {
        return Netheopoiesis.getInstance().listenerManager;
    }

    public static TaskManager getRunnableManager() {
        return Netheopoiesis.getInstance().taskManager;
    }

    public static MobManager getMobManager() {
        return Netheopoiesis.getInstance().mobManager;
    }

    public static Purification getPurificationMemory() {
        return Netheopoiesis.getInstance().purification;
    }

    public static Registry getPlantRegistry() {
        return Netheopoiesis.getInstance().registry;
    }
}
