package teamUnknown.immersion.features.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FeatureProperties {

    public String name() default "Unnamed Feature";
    public boolean doConfigurationRegistration() default false;
    public boolean doItemsRegistration() default false;
    public boolean doBlocksRegistration() default false;
    public boolean doWorldGenerationRegistration() default false;
    public boolean doEventListenersRegistration() default false;
    public boolean doEntitiesRegistration() default false;
    public boolean doCraftingRegistration() default false;
    public boolean doModCompatibilityRegistration() default false;
}
