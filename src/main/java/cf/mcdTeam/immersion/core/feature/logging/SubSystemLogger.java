package cf.mcdTeam.immersion.core.feature.logging;

import cf.mcdTeam.immersion.Immersion;

/**
 *
 */
public class SubSystemLogger implements ILogger {
    private String _subSystemName;

    protected SubSystemLogger(String subSystemName) {
        this._subSystemName = subSystemName;
    }

    public static SubSystemLogger getLoggerForSubsystem(Class c){
        return new SubSystemLogger(c.getSimpleName());
    }

    @Override
    public void info(String format, Object... args) 
    {
        Immersion.log.info(String.format("[" + this._subSystemName + "]: " + format, args));
    }
    
    @Override
    public void debug(String format, Object... args) 
    {
        Immersion.log.debug(String.format("[" + this._subSystemName + "]: " + format, args));
    }
}
