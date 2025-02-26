package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final BehavioLibraryAccessors laccForBehavioLibraryAccessors = new BehavioLibraryAccessors(owner);
    private final BillingLibraryAccessors laccForBillingLibraryAccessors = new BillingLibraryAccessors(owner);
    private final ComposeLibraryAccessors laccForComposeLibraryAccessors = new ComposeLibraryAccessors(owner);
    private final EzLibraryAccessors laccForEzLibraryAccessors = new EzLibraryAccessors(owner);
    private final GlideLibraryAccessors laccForGlideLibraryAccessors = new GlideLibraryAccessors(owner);
    private final JodaLibraryAccessors laccForJodaLibraryAccessors = new JodaLibraryAccessors(owner);
    private final KotlinLibraryAccessors laccForKotlinLibraryAccessors = new KotlinLibraryAccessors(owner);
    private final KotlinxLibraryAccessors laccForKotlinxLibraryAccessors = new KotlinxLibraryAccessors(owner);
    private final RtlLibraryAccessors laccForRtlLibraryAccessors = new RtlLibraryAccessors(owner);
    private final RustoreLibraryAccessors laccForRustoreLibraryAccessors = new RustoreLibraryAccessors(owner);
    private final RxLibraryAccessors laccForRxLibraryAccessors = new RxLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Dependency provider for <b>gson</b> with <b>com.google.code.gson:gson</b> coordinates and
     * with version reference <b>gson</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getGson() {
        return create("gson");
    }

    /**
     * Dependency provider for <b>material</b> with <b>com.google.android.material:material</b> coordinates and
     * with version reference <b>material</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getMaterial() {
        return create("material");
    }

    /**
     * Dependency provider for <b>patternLockView</b> with <b>com.github.aritraroy:patternLockView</b> coordinates and
     * with version reference <b>patternLockView</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getPatternLockView() {
        return create("patternLockView");
    }

    /**
     * Group of libraries at <b>androidx</b>
     */
    public AndroidxLibraryAccessors getAndroidx() {
        return laccForAndroidxLibraryAccessors;
    }

    /**
     * Group of libraries at <b>behavio</b>
     */
    public BehavioLibraryAccessors getBehavio() {
        return laccForBehavioLibraryAccessors;
    }

    /**
     * Group of libraries at <b>billing</b>
     */
    public BillingLibraryAccessors getBilling() {
        return laccForBillingLibraryAccessors;
    }

    /**
     * Group of libraries at <b>compose</b>
     */
    public ComposeLibraryAccessors getCompose() {
        return laccForComposeLibraryAccessors;
    }

    /**
     * Group of libraries at <b>ez</b>
     */
    public EzLibraryAccessors getEz() {
        return laccForEzLibraryAccessors;
    }

    /**
     * Group of libraries at <b>glide</b>
     */
    public GlideLibraryAccessors getGlide() {
        return laccForGlideLibraryAccessors;
    }

    /**
     * Group of libraries at <b>joda</b>
     */
    public JodaLibraryAccessors getJoda() {
        return laccForJodaLibraryAccessors;
    }

    /**
     * Group of libraries at <b>kotlin</b>
     */
    public KotlinLibraryAccessors getKotlin() {
        return laccForKotlinLibraryAccessors;
    }

    /**
     * Group of libraries at <b>kotlinx</b>
     */
    public KotlinxLibraryAccessors getKotlinx() {
        return laccForKotlinxLibraryAccessors;
    }

    /**
     * Group of libraries at <b>rtl</b>
     */
    public RtlLibraryAccessors getRtl() {
        return laccForRtlLibraryAccessors;
    }

    /**
     * Group of libraries at <b>rustore</b>
     */
    public RustoreLibraryAccessors getRustore() {
        return laccForRustoreLibraryAccessors;
    }

    /**
     * Group of libraries at <b>rx</b>
     */
    public RxLibraryAccessors getRx() {
        return laccForRxLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxBiometricLibraryAccessors laccForAndroidxBiometricLibraryAccessors = new AndroidxBiometricLibraryAccessors(owner);
        private final AndroidxCoreLibraryAccessors laccForAndroidxCoreLibraryAccessors = new AndroidxCoreLibraryAccessors(owner);
        private final AndroidxLifecycleLibraryAccessors laccForAndroidxLifecycleLibraryAccessors = new AndroidxLifecycleLibraryAccessors(owner);
        private final AndroidxRoomLibraryAccessors laccForAndroidxRoomLibraryAccessors = new AndroidxRoomLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>appcompat</b> with <b>androidx.appcompat:appcompat</b> coordinates and
         * with version reference <b>androidx.appcompat</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAppcompat() {
            return create("androidx.appcompat");
        }

        /**
         * Dependency provider for <b>constraintlayout</b> with <b>androidx.constraintlayout:constraintlayout</b> coordinates and
         * with version reference <b>androidx.constraintlayout</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getConstraintlayout() {
            return create("androidx.constraintlayout");
        }

        /**
         * Dependency provider for <b>customView</b> with <b>androidx.customview:customview</b> coordinates and
         * with version reference <b>androidx.customView</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCustomView() {
            return create("androidx.customView");
        }

        /**
         * Dependency provider for <b>customViewPooling</b> with <b>androidx.customview:customview-poolingcontainer</b> coordinates and
         * with version reference <b>androidx.customViewPooling</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCustomViewPooling() {
            return create("androidx.customViewPooling");
        }

        /**
         * Dependency provider for <b>documentfile</b> with <b>androidx.documentfile:documentfile</b> coordinates and
         * with version reference <b>androidx.documentfile</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDocumentfile() {
            return create("androidx.documentfile");
        }

        /**
         * Dependency provider for <b>exifinterface</b> with <b>androidx.exifinterface:exifinterface</b> coordinates and
         * with version reference <b>androidx.exifinterface</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getExifinterface() {
            return create("androidx.exifinterface");
        }

        /**
         * Dependency provider for <b>swiperefreshlayout</b> with <b>androidx.swiperefreshlayout:swiperefreshlayout</b> coordinates and
         * with version reference <b>androidx.swiperefreshlayout</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSwiperefreshlayout() {
            return create("androidx.swiperefreshlayout");
        }

        /**
         * Group of libraries at <b>androidx.biometric</b>
         */
        public AndroidxBiometricLibraryAccessors getBiometric() {
            return laccForAndroidxBiometricLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.core</b>
         */
        public AndroidxCoreLibraryAccessors getCore() {
            return laccForAndroidxCoreLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.lifecycle</b>
         */
        public AndroidxLifecycleLibraryAccessors getLifecycle() {
            return laccForAndroidxLifecycleLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.room</b>
         */
        public AndroidxRoomLibraryAccessors getRoom() {
            return laccForAndroidxRoomLibraryAccessors;
        }

    }

    public static class AndroidxBiometricLibraryAccessors extends SubDependencyFactory {

        public AndroidxBiometricLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.biometric:biometric-ktx</b> coordinates and
         * with version reference <b>androidx.biometricKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.biometric.ktx");
        }

    }

    public static class AndroidxCoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.core:core-ktx</b> coordinates and
         * with version reference <b>androidx.coreKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.core.ktx");
        }

    }

    public static class AndroidxLifecycleLibraryAccessors extends SubDependencyFactory {
        private final AndroidxLifecycleViewModelLibraryAccessors laccForAndroidxLifecycleViewModelLibraryAccessors = new AndroidxLifecycleViewModelLibraryAccessors(owner);

        public AndroidxLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.lifecycle:lifecycle-runtime-compose</b> coordinates and
         * with version reference <b>androidx.lifecycle</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("androidx.lifecycle.compose");
        }

        /**
         * Dependency provider for <b>process</b> with <b>androidx.lifecycle:lifecycle-process</b> coordinates and
         * with version reference <b>androidx.lifecycle</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getProcess() {
            return create("androidx.lifecycle.process");
        }

        /**
         * Dependency provider for <b>runtime</b> with <b>androidx.lifecycle:lifecycle-runtime-ktx</b> coordinates and
         * with version reference <b>androidx.lifecycle</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRuntime() {
            return create("androidx.lifecycle.runtime");
        }

        /**
         * Group of libraries at <b>androidx.lifecycle.viewModel</b>
         */
        public AndroidxLifecycleViewModelLibraryAccessors getViewModel() {
            return laccForAndroidxLifecycleViewModelLibraryAccessors;
        }

    }

    public static class AndroidxLifecycleViewModelLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxLifecycleViewModelLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>viewModel</b> with <b>androidx.lifecycle:lifecycle-viewmodel-ktx</b> coordinates and
         * with version reference <b>androidx.lifecycle</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.lifecycle.viewModel");
        }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.lifecycle:lifecycle-viewmodel-compose</b> coordinates and
         * with version reference <b>androidx.lifecycle</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("androidx.lifecycle.viewModel.compose");
        }

    }

    public static class AndroidxRoomLibraryAccessors extends SubDependencyFactory {

        public AndroidxRoomLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compiler</b> with <b>androidx.room:room-compiler</b> coordinates and
         * with version reference <b>room</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompiler() {
            return create("androidx.room.compiler");
        }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.room:room-ktx</b> coordinates and
         * with version reference <b>room</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.room.ktx");
        }

        /**
         * Dependency provider for <b>runtime</b> with <b>androidx.room:room-runtime</b> coordinates and
         * with version reference <b>room</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRuntime() {
            return create("androidx.room.runtime");
        }

    }

    public static class BehavioLibraryAccessors extends SubDependencyFactory {

        public BehavioLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>rule</b> with <b>com.github.Liverm0r:BehavioRule</b> coordinates and
         * with version reference <b>behavioRule</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRule() {
            return create("behavio.rule");
        }

    }

    public static class BillingLibraryAccessors extends SubDependencyFactory {

        public BillingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>client</b> with <b>com.android.billingclient:billing</b> coordinates and
         * with version reference <b>billing</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getClient() {
            return create("billing.client");
        }

    }

    public static class ComposeLibraryAccessors extends SubDependencyFactory {
        private final ComposeMaterialLibraryAccessors laccForComposeMaterialLibraryAccessors = new ComposeMaterialLibraryAccessors(owner);
        private final ComposeUiToolingLibraryAccessors laccForComposeUiToolingLibraryAccessors = new ComposeUiToolingLibraryAccessors(owner);
        private final ComposeViewLibraryAccessors laccForComposeViewLibraryAccessors = new ComposeViewLibraryAccessors(owner);

        public ComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>activity</b> with <b>androidx.activity:activity-compose</b> coordinates and
         * with version reference <b>composeActivity</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getActivity() {
            return create("compose.activity");
        }

        /**
         * Dependency provider for <b>animation</b> with <b>androidx.compose.animation:animation</b> coordinates and
         * with version reference <b>compose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAnimation() {
            return create("compose.animation");
        }

        /**
         * Dependency provider for <b>compiler</b> with <b>androidx.compose.compiler:compiler</b> coordinates and
         * with version reference <b>composeCompiler</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompiler() {
            return create("compose.compiler");
        }

        /**
         * Dependency provider for <b>foundation</b> with <b>androidx.compose.foundation:foundation</b> coordinates and
         * with version reference <b>compose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFoundation() {
            return create("compose.foundation");
        }

        /**
         * Dependency provider for <b>material2</b> with <b>androidx.compose.material:material</b> coordinates and
         * with version reference <b>compose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial2() {
            return create("compose.material2");
        }

        /**
         * Dependency provider for <b>material3</b> with <b>androidx.compose.material3:material3</b> coordinates and
         * with version reference <b>composeMaterial3</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial3() {
            return create("compose.material3");
        }

        /**
         * Dependency provider for <b>runtime</b> with <b>androidx.compose.runtime:runtime</b> coordinates and
         * with version reference <b>compose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRuntime() {
            return create("compose.runtime");
        }

        /**
         * Dependency provider for <b>ui</b> with <b>androidx.compose.ui:ui</b> coordinates and
         * with version reference <b>compose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getUi() {
            return create("compose.ui");
        }

        /**
         * Group of libraries at <b>compose.material</b>
         */
        public ComposeMaterialLibraryAccessors getMaterial() {
            return laccForComposeMaterialLibraryAccessors;
        }

        /**
         * Group of libraries at <b>compose.uiTooling</b>
         */
        public ComposeUiToolingLibraryAccessors getUiTooling() {
            return laccForComposeUiToolingLibraryAccessors;
        }

        /**
         * Group of libraries at <b>compose.view</b>
         */
        public ComposeViewLibraryAccessors getView() {
            return laccForComposeViewLibraryAccessors;
        }

    }

    public static class ComposeMaterialLibraryAccessors extends SubDependencyFactory {

        public ComposeMaterialLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>icons</b> with <b>androidx.compose.material:material-icons-extended</b> coordinates and
         * with version reference <b>compose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getIcons() {
            return create("compose.material.icons");
        }

    }

    public static class ComposeUiToolingLibraryAccessors extends SubDependencyFactory {

        public ComposeUiToolingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>debug</b> with <b>androidx.compose.ui:ui-tooling</b> coordinates and
         * with version reference <b>compose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDebug() {
            return create("compose.uiTooling.debug");
        }

        /**
         * Dependency provider for <b>preview</b> with <b>androidx.compose.ui:ui-tooling-preview</b> coordinates and
         * with version reference <b>compose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPreview() {
            return create("compose.uiTooling.preview");
        }

    }

    public static class ComposeViewLibraryAccessors extends SubDependencyFactory {

        public ComposeViewLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>binding</b> with <b>androidx.compose.ui:ui-viewbinding</b> coordinates and
         * with version reference <b>compose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getBinding() {
            return create("compose.view.binding");
        }

    }

    public static class EzLibraryAccessors extends SubDependencyFactory {

        public EzLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>vcard</b> with <b>com.googlecode.ez-vcard:ez-vcard</b> coordinates and
         * with version reference <b>ezVcard</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getVcard() {
            return create("ez.vcard");
        }

    }

    public static class GlideLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public GlideLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>glide</b> with <b>com.github.bumptech.glide:glide</b> coordinates and
         * with version reference <b>glide</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("glide");
        }

        /**
         * Dependency provider for <b>compiler</b> with <b>com.github.bumptech.glide:compiler</b> coordinates and
         * with version reference <b>glide</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompiler() {
            return create("glide.compiler");
        }

        /**
         * Dependency provider for <b>compose</b> with <b>com.github.bumptech.glide:compose</b> coordinates and
         * with version reference <b>glideCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("glide.compose");
        }

    }

    public static class JodaLibraryAccessors extends SubDependencyFactory {

        public JodaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>time</b> with <b>joda-time:joda-time</b> coordinates and
         * with version reference <b>jodaTime</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTime() {
            return create("joda.time");
        }

    }

    public static class KotlinLibraryAccessors extends SubDependencyFactory {
        private final KotlinImmutableLibraryAccessors laccForKotlinImmutableLibraryAccessors = new KotlinImmutableLibraryAccessors(owner);

        public KotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>kotlin.immutable</b>
         */
        public KotlinImmutableLibraryAccessors getImmutable() {
            return laccForKotlinImmutableLibraryAccessors;
        }

    }

    public static class KotlinImmutableLibraryAccessors extends SubDependencyFactory {

        public KotlinImmutableLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>collections</b> with <b>org.jetbrains.kotlinx:kotlinx-collections-immutable</b> coordinates and
         * with version reference <b>kotlin.immutable.collections</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCollections() {
            return create("kotlin.immutable.collections");
        }

    }

    public static class KotlinxLibraryAccessors extends SubDependencyFactory {
        private final KotlinxSerializationLibraryAccessors laccForKotlinxSerializationLibraryAccessors = new KotlinxSerializationLibraryAccessors(owner);

        public KotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>kotlinx.serialization</b>
         */
        public KotlinxSerializationLibraryAccessors getSerialization() {
            return laccForKotlinxSerializationLibraryAccessors;
        }

    }

    public static class KotlinxSerializationLibraryAccessors extends SubDependencyFactory {

        public KotlinxSerializationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>json</b> with <b>org.jetbrains.kotlinx:kotlinx-serialization-json</b> coordinates and
         * with version reference <b>kotlinxSerializationJson</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJson() {
            return create("kotlinx.serialization.json");
        }

    }

    public static class RtlLibraryAccessors extends SubDependencyFactory {

        public RtlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>viewpager</b> with <b>com.github.duolingo:rtl-viewpager</b> coordinates and
         * with version reference <b>rtlViewpager</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getViewpager() {
            return create("rtl.viewpager");
        }

    }

    public static class RustoreLibraryAccessors extends SubDependencyFactory {

        public RustoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>client</b> with <b>ru.rustore.sdk:billingclient</b> coordinates and
         * with version reference <b>rustore</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getClient() {
            return create("rustore.client");
        }

    }

    public static class RxLibraryAccessors extends SubDependencyFactory {

        public RxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>animation</b> with <b>com.mikhaellopez:rxanimation</b> coordinates and
         * with version reference <b>rxAnimation</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAnimation() {
            return create("rx.animation");
        }

        /**
         * Dependency provider for <b>java</b> with <b>io.reactivex.rxjava3:rxjava</b> coordinates and
         * with version reference <b>rxJava3</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJava() {
            return create("rx.java");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final AndroidxVersionAccessors vaccForAndroidxVersionAccessors = new AndroidxVersionAccessors(providers, config);
        private final AppVersionAccessors vaccForAppVersionAccessors = new AppVersionAccessors(providers, config);
        private final GradlePluginsVersionAccessors vaccForGradlePluginsVersionAccessors = new GradlePluginsVersionAccessors(providers, config);
        private final KotlinVersionAccessors vaccForKotlinVersionAccessors = new KotlinVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>behavioRule</b> with value <b>1.0.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBehavioRule() { return getVersion("behavioRule"); }

        /**
         * Version alias <b>billing</b> with value <b>6.0.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBilling() { return getVersion("billing"); }

        /**
         * Version alias <b>compose</b> with value <b>1.7.6</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCompose() { return getVersion("compose"); }

        /**
         * Version alias <b>composeActivity</b> with value <b>1.9.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getComposeActivity() { return getVersion("composeActivity"); }

        /**
         * Version alias <b>composeCompiler</b> with value <b>1.5.15</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getComposeCompiler() { return getVersion("composeCompiler"); }

        /**
         * Version alias <b>composeMaterial3</b> with value <b>1.3.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getComposeMaterial3() { return getVersion("composeMaterial3"); }

        /**
         * Version alias <b>detekt</b> with value <b>1.23.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDetekt() { return getVersion("detekt"); }

        /**
         * Version alias <b>ezVcard</b> with value <b>0.11.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getEzVcard() { return getVersion("ezVcard"); }

        /**
         * Version alias <b>glide</b> with value <b>4.16.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGlide() { return getVersion("glide"); }

        /**
         * Version alias <b>glideCompose</b> with value <b>1.0.0-beta01</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGlideCompose() { return getVersion("glideCompose"); }

        /**
         * Version alias <b>gson</b> with value <b>2.10.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGson() { return getVersion("gson"); }

        /**
         * Version alias <b>jodaTime</b> with value <b>2.12.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJodaTime() { return getVersion("jodaTime"); }

        /**
         * Version alias <b>kotlinxSerializationJson</b> with value <b>1.6.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlinxSerializationJson() { return getVersion("kotlinxSerializationJson"); }

        /**
         * Version alias <b>ksp</b> with value <b>1.9.25-1.0.20</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKsp() { return getVersion("ksp"); }

        /**
         * Version alias <b>material</b> with value <b>1.12.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMaterial() { return getVersion("material"); }

        /**
         * Version alias <b>patternLockView</b> with value <b>a90b0d4bf0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPatternLockView() { return getVersion("patternLockView"); }

        /**
         * Version alias <b>recyclerviewFastscroller</b> with value <b>1b9ae542b9</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRecyclerviewFastscroller() { return getVersion("recyclerviewFastscroller"); }

        /**
         * Version alias <b>reprint</b> with value <b>2cb206415d</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getReprint() { return getVersion("reprint"); }

        /**
         * Version alias <b>room</b> with value <b>2.6.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRoom() { return getVersion("room"); }

        /**
         * Version alias <b>rtlViewpager</b> with value <b>940f12724f</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRtlViewpager() { return getVersion("rtlViewpager"); }

        /**
         * Version alias <b>rustore</b> with value <b>6.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRustore() { return getVersion("rustore"); }

        /**
         * Version alias <b>rxAnimation</b> with value <b>2.1.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRxAnimation() { return getVersion("rxAnimation"); }

        /**
         * Version alias <b>rxJava3</b> with value <b>3.1.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRxJava3() { return getVersion("rxJava3"); }

        /**
         * Group of versions at <b>versions.androidx</b>
         */
        public AndroidxVersionAccessors getAndroidx() {
            return vaccForAndroidxVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.app</b>
         */
        public AppVersionAccessors getApp() {
            return vaccForAppVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.gradlePlugins</b>
         */
        public GradlePluginsVersionAccessors getGradlePlugins() {
            return vaccForGradlePluginsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.kotlin</b>
         */
        public KotlinVersionAccessors getKotlin() {
            return vaccForKotlinVersionAccessors;
        }

    }

    public static class AndroidxVersionAccessors extends VersionFactory  {

        public AndroidxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>androidx.appcompat</b> with value <b>1.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAppcompat() { return getVersion("androidx.appcompat"); }

        /**
         * Version alias <b>androidx.biometricKtx</b> with value <b>1.2.0-alpha05</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBiometricKtx() { return getVersion("androidx.biometricKtx"); }

        /**
         * Version alias <b>androidx.constraintlayout</b> with value <b>2.2.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getConstraintlayout() { return getVersion("androidx.constraintlayout"); }

        /**
         * Version alias <b>androidx.coreKtx</b> with value <b>1.13.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCoreKtx() { return getVersion("androidx.coreKtx"); }

        /**
         * Version alias <b>androidx.customView</b> with value <b>1.2.0-alpha02</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCustomView() { return getVersion("androidx.customView"); }

        /**
         * Version alias <b>androidx.customViewPooling</b> with value <b>1.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCustomViewPooling() { return getVersion("androidx.customViewPooling"); }

        /**
         * Version alias <b>androidx.documentfile</b> with value <b>1.0.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDocumentfile() { return getVersion("androidx.documentfile"); }

        /**
         * Version alias <b>androidx.exifinterface</b> with value <b>1.3.7</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getExifinterface() { return getVersion("androidx.exifinterface"); }

        /**
         * Version alias <b>androidx.lifecycle</b> with value <b>2.8.7</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLifecycle() { return getVersion("androidx.lifecycle"); }

        /**
         * Version alias <b>androidx.swiperefreshlayout</b> with value <b>1.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSwiperefreshlayout() { return getVersion("androidx.swiperefreshlayout"); }

    }

    public static class AppVersionAccessors extends VersionFactory  {

        private final AppBuildVersionAccessors vaccForAppBuildVersionAccessors = new AppBuildVersionAccessors(providers, config);
        public AppVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.app.build</b>
         */
        public AppBuildVersionAccessors getBuild() {
            return vaccForAppBuildVersionAccessors;
        }

    }

    public static class AppBuildVersionAccessors extends VersionFactory  {

        public AppBuildVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>app.build.compileSDKVersion</b> with value <b>34</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCompileSDKVersion() { return getVersion("app.build.compileSDKVersion"); }

        /**
         * Version alias <b>app.build.javaVersion</b> with value <b>VERSION_17</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJavaVersion() { return getVersion("app.build.javaVersion"); }

        /**
         * Version alias <b>app.build.kotlinJVMTarget</b> with value <b>17</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlinJVMTarget() { return getVersion("app.build.kotlinJVMTarget"); }

        /**
         * Version alias <b>app.build.minimumSDK</b> with value <b>23</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMinimumSDK() { return getVersion("app.build.minimumSDK"); }

        /**
         * Version alias <b>app.build.targetSDK</b> with value <b>34</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTargetSDK() { return getVersion("app.build.targetSDK"); }

    }

    public static class GradlePluginsVersionAccessors extends VersionFactory  {

        public GradlePluginsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>gradlePlugins.agp</b> with value <b>8.5.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAgp() { return getVersion("gradlePlugins.agp"); }

    }

    public static class KotlinVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        private final KotlinImmutableVersionAccessors vaccForKotlinImmutableVersionAccessors = new KotlinImmutableVersionAccessors(providers, config);
        public KotlinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotlin</b> with value <b>1.9.25</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("kotlin"); }

        /**
         * Group of versions at <b>versions.kotlin.immutable</b>
         */
        public KotlinImmutableVersionAccessors getImmutable() {
            return vaccForKotlinImmutableVersionAccessors;
        }

    }

    public static class KotlinImmutableVersionAccessors extends VersionFactory  {

        public KotlinImmutableVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotlin.immutable.collections</b> with value <b>0.3.6</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCollections() { return getVersion("kotlin.immutable.collections"); }

    }

    public static class BundleAccessors extends BundleFactory {
        private final ComposeBundleAccessors baccForComposeBundleAccessors = new ComposeBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>lifecycle</b> which contains the following dependencies:
         * <ul>
         *    <li>androidx.lifecycle:lifecycle-runtime-compose</li>
         *    <li>androidx.lifecycle:lifecycle-runtime-ktx</li>
         *    <li>androidx.lifecycle:lifecycle-viewmodel-ktx</li>
         *    <li>androidx.lifecycle:lifecycle-viewmodel-compose</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getLifecycle() {
            return createBundle("lifecycle");
        }

        /**
         * Dependency bundle provider for <b>room</b> which contains the following dependencies:
         * <ul>
         *    <li>androidx.room:room-ktx</li>
         *    <li>androidx.room:room-runtime</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getRoom() {
            return createBundle("room");
        }

        /**
         * Group of bundles at <b>bundles.compose</b>
         */
        public ComposeBundleAccessors getCompose() {
            return baccForComposeBundleAccessors;
        }

    }

    public static class ComposeBundleAccessors extends BundleFactory  implements BundleNotationSupplier{

        public ComposeBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>compose</b> which contains the following dependencies:
         * <ul>
         *    <li>androidx.activity:activity-compose</li>
         *    <li>androidx.compose.animation:animation</li>
         *    <li>androidx.compose.compiler:compiler</li>
         *    <li>androidx.compose.foundation:foundation</li>
         *    <li>androidx.compose.material:material-icons-extended</li>
         *    <li>androidx.compose.material3:material3</li>
         *    <li>androidx.compose.runtime:runtime</li>
         *    <li>androidx.compose.ui:ui</li>
         *    <li>androidx.compose.ui:ui-tooling-preview</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> asProvider() {
            return createBundle("compose");
        }

        /**
         * Dependency bundle provider for <b>compose.preview</b> which contains the following dependencies:
         * <ul>
         *    <li>androidx.customview:customview</li>
         *    <li>androidx.customview:customview-poolingcontainer</li>
         *    <li>androidx.compose.ui:ui-tooling</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getPreview() {
            return createBundle("compose.preview");
        }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>android</b> with plugin id <b>com.android.application</b> and
         * with version reference <b>gradlePlugins.agp</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getAndroid() { return createPlugin("android"); }

        /**
         * Plugin provider for <b>detekt</b> with plugin id <b>io.gitlab.arturbosch.detekt</b> and
         * with version reference <b>detekt</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getDetekt() { return createPlugin("detekt"); }

        /**
         * Plugin provider for <b>kotlinAndroid</b> with plugin id <b>org.jetbrains.kotlin.android</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getKotlinAndroid() { return createPlugin("kotlinAndroid"); }

        /**
         * Plugin provider for <b>kotlinSerialization</b> with plugin id <b>org.jetbrains.kotlin.plugin.serialization</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getKotlinSerialization() { return createPlugin("kotlinSerialization"); }

        /**
         * Plugin provider for <b>ksp</b> with plugin id <b>com.google.devtools.ksp</b> and
         * with version reference <b>ksp</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getKsp() { return createPlugin("ksp"); }

        /**
         * Plugin provider for <b>library</b> with plugin id <b>com.android.library</b> and
         * with version reference <b>gradlePlugins.agp</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getLibrary() { return createPlugin("library"); }

        /**
         * Plugin provider for <b>parcelize</b> with plugin id <b>org.jetbrains.kotlin.plugin.parcelize</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getParcelize() { return createPlugin("parcelize"); }

    }

}
