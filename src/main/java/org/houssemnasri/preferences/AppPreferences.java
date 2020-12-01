package org.houssemnasri.preferences;

import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

public class AppPreferences implements PreferencesService, PreferencesKeys {

    private static AppPreferences instance = null;

    private final Map<String, Object> defaultsMapping = new HashMap<>();
    private final Preferences preferences;

    private AppPreferences() {
        preferences = Preferences.userRoot().node(getPreferencesNodePath().toString());
        initDefaults();
    }

    private void initDefaults() {
        defaultsMapping.put(PREF_MIN_RANGE_KEY, 0);
        defaultsMapping.put(PREF_MAX_RANGE_KEY, 100);
    }

    public synchronized static AppPreferences getInstance() {
        if (instance == null)
            instance = new AppPreferences();
        return instance;
    }

    @Override
    public int getMinRange() {
        return preferences.getInt(PREF_MIN_RANGE_KEY, (int) defaultsMapping.get(PREF_MIN_RANGE_KEY));
    }

    @Override
    public int getMaxRange() {
        return preferences.getInt(PREF_MAX_RANGE_KEY, (int) defaultsMapping.get(PREF_MAX_RANGE_KEY));
    }

    @Override
    public void setMinRange(int min) {
        preferences.putInt(PREF_MIN_RANGE_KEY, min);
    }

    @Override
    public void setMaxRange(int max) {
        preferences.putInt(PREF_MAX_RANGE_KEY, max);
    }

    @Override
    public Map<String, Object> getDefaultsMapping() {
        return Collections.unmodifiableMap(defaultsMapping);
    }

    @Override
    public Path getPreferencesNodePath() {
        return Path.of("org", "mindreader");
    }
}
