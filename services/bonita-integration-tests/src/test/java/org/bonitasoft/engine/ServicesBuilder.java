package org.bonitasoft.engine;

import org.bonitasoft.engine.archive.ArchiveService;
import org.bonitasoft.engine.authentication.AuthenticationService;
import org.bonitasoft.engine.cache.CacheService;
import org.bonitasoft.engine.classloader.ClassLoaderService;
import org.bonitasoft.engine.command.CommandService;
import org.bonitasoft.engine.command.model.SCommandBuilderAccessor;
import org.bonitasoft.engine.data.DataService;
import org.bonitasoft.engine.data.definition.model.builder.SDataDefinitionBuilders;
import org.bonitasoft.engine.data.instance.api.DataInstanceService;
import org.bonitasoft.engine.data.instance.model.builder.SDataInstanceBuilders;
import org.bonitasoft.engine.data.model.builder.SDataSourceBuilder;
import org.bonitasoft.engine.data.model.builder.SDataSourceParameterBuilder;
import org.bonitasoft.engine.dependency.DependencyService;
import org.bonitasoft.engine.dependency.model.builder.DependencyBuilder;
import org.bonitasoft.engine.dependency.model.builder.DependencyBuilderAccessor;
import org.bonitasoft.engine.dependency.model.builder.DependencyMappingBuilder;
import org.bonitasoft.engine.events.EventService;
import org.bonitasoft.engine.exceptions.ExceptionsManager;
import org.bonitasoft.engine.expression.ExpressionService;
import org.bonitasoft.engine.identity.IdentityService;
import org.bonitasoft.engine.identity.model.builder.IdentityModelBuilder;
import org.bonitasoft.engine.log.technical.TechnicalLoggerService;
import org.bonitasoft.engine.platform.PlatformService;
import org.bonitasoft.engine.platform.authentication.PlatformAuthenticationService;
import org.bonitasoft.engine.platform.command.PlatformCommandService;
import org.bonitasoft.engine.platform.command.model.SPlatformCommandBuilderAccessor;
import org.bonitasoft.engine.platform.model.builder.SPlatformBuilder;
import org.bonitasoft.engine.platform.model.builder.STenantBuilder;
import org.bonitasoft.engine.platform.session.PlatformSessionService;
import org.bonitasoft.engine.profile.ProfileService;
import org.bonitasoft.engine.queriablelogger.model.builder.SQueriableLogModelBuilder;
import org.bonitasoft.engine.recorder.Recorder;
import org.bonitasoft.engine.scheduler.SchedulerService;
import org.bonitasoft.engine.services.PersistenceService;
import org.bonitasoft.engine.services.QueriableLoggerService;
import org.bonitasoft.engine.session.SessionService;
import org.bonitasoft.engine.sessionaccessor.SessionAccessor;
import org.bonitasoft.engine.test.util.ServicesAccessor;
import org.bonitasoft.engine.transaction.TransactionService;
import org.bonitasoft.engine.work.WorkService;
import org.bonitasoft.engine.xml.Parser;

/**
 * You can set these system properties to change implementations
 * sysprop.bonita.db.vendor
 * change the DB:
 * h2 (default)
 * mysql
 * oracle
 * postgres
 * bonita.test.identity.service
 * change the identity service
 * bonita-identity-impl (default)
 * bonita.test.identity.model
 * change the identity model
 * bonita-identity-model-impl (default)
 * 
 * @author Baptiste Mesta
 * @author Elias Ricken de Medeiros
 */
public class ServicesBuilder {

    ServicesAccessor accessor;

    public ServicesBuilder() {
        super();
        setAccessor(ServicesAccessor.getInstance());
    }

    public ServicesAccessor getAccessor() {
        return accessor;
    }

    public void setAccessor(final ServicesAccessor accessor) {
        this.accessor = accessor;
    }

    public QueriableLoggerService buildQueriableLogger(final String name) {
        return getAccessor().getInstanceOf(name, QueriableLoggerService.class);
    }

    public QueriableLoggerService buildQueriableLogger() {
        return this.buildQueriableLogger("syncQueriableLoggerService"); // default is the sync one
    }

    public IdentityModelBuilder buildIdentityModelBuilder() {
        return getAccessor().getInstanceOf(IdentityModelBuilder.class);
    }

    public SDataInstanceBuilders builderSDataInstanceBuilder() {
        return getAccessor().getInstanceOf(SDataInstanceBuilders.class);
    }

    public SDataDefinitionBuilders builderSDataDefinitionBuilders() {
        return getAccessor().getInstanceOf(SDataDefinitionBuilders.class);
    }

    public DependencyBuilder buildDependencyModelBuilder() {
        return getAccessor().getInstanceOf(DependencyBuilder.class);
    }

    public DependencyMappingBuilder buildDependencyMappingModelBuilder() {
        return getAccessor().getInstanceOf(DependencyMappingBuilder.class);
    }

    public PersistenceService buildPersistence() {
        return this.buildPersistence("persistenceService");
    }

    public PersistenceService buildPersistence(final String name) {
        return getAccessor().getInstanceOf(name, PersistenceService.class);
    }

    public PersistenceService buildJournal() {
        return this.buildPersistence();
    }

    public PersistenceService buildHistory() {
        return this.buildPersistence("history");
    }

    public Recorder buildRecorder(final boolean sync) {
        String synchType = "recorderAsync";
        if (sync) {
            synchType = "recorderSync";
        }
        return getAccessor().getInstanceOf(synchType, Recorder.class);
    }

    public TransactionService buildTransactionService() {
        return getAccessor().getInstanceOf(TransactionService.class);
    }

    public PlatformService buildPlatformService() {
        return getAccessor().getInstanceOf(PlatformService.class);
    }

    public DataService buildDataService() {
        return getAccessor().getInstanceOf(DataService.class);
    }

    public SDataSourceParameterBuilder buildDataSourceParameterModelBuilder() {
        return getAccessor().getInstanceOf(SDataSourceParameterBuilder.class);
    }

    public SDataSourceBuilder buildDataSourceModelBuilder() {
        return getAccessor().getInstanceOf(SDataSourceBuilder.class);
    }

    public SPlatformBuilder buildPlatformBuilder() {
        return getAccessor().getInstanceOf(SPlatformBuilder.class);
    }

    public STenantBuilder buildTenantBuilder() {
        return getAccessor().getInstanceOf(STenantBuilder.class);
    }

    public SessionAccessor buildSessionAccessor() {
        return getAccessor().getInstanceOf(SessionAccessor.class);
    }

    public IdentityService buildIdentityService() {
        return getAccessor().getInstanceOf(IdentityService.class);
    }

    public ArchiveService buildArchiveService() {
        return getAccessor().getInstanceOf(ArchiveService.class);
    }

    public ExpressionService buildExpressionService() {
        return getAccessor().getInstanceOf(ExpressionService.class);
    }

    public DataInstanceService buildDataInstanceService() {
        return getAccessor().getInstanceOf(DataInstanceService.class);
    }

    public DependencyService buildDependencyService() {
        return getAccessor().getInstanceOf("dependencyService", DependencyService.class);
    }

    public DependencyService buildPlatformDependencyService() {
        return getAccessor().getInstanceOf("platformDependencyService", DependencyService.class);
    }

    public SQueriableLogModelBuilder buildQueriableLogModelBuilder() {
        return getAccessor().getInstanceOf(SQueriableLogModelBuilder.class);
    }

    public SchedulerService buildSchedulerService() {
        return getAccessor().getInstanceOf(SchedulerService.class);
    }

    public ClassLoaderService buildClassLoaderService() {
        return getAccessor().getInstanceOf(ClassLoaderService.class);
    }

    public EventService buildEventService() {
        return getAccessor().getInstanceOf(EventService.class);
    }

    public ExceptionsManager getExceptionsManager() {
        return getAccessor().getInstanceOf(ExceptionsManager.class);
    }

    public CacheService buildCacheService() {
        return getAccessor().getInstanceOf(CacheService.class);
    }

    public AuthenticationService buildAuthenticationService() {
        return getAccessor().getInstanceOf(AuthenticationService.class);
    }

    public PlatformAuthenticationService buildPlatformAuthenticationService() {
        return getAccessor().getInstanceOf(PlatformAuthenticationService.class);
    }

    public SessionService buildSessionService() {
        return getAccessor().getInstanceOf(SessionService.class);
    }

    public PlatformSessionService buildPlatformSessionService() {
        return getAccessor().getInstanceOf(PlatformSessionService.class);
    }

    public TechnicalLoggerService buildTechnicalLoggerService() {
        return getAccessor().getInstanceOf(TechnicalLoggerService.class);
    }

    public CommandService buildCommandService() {
        return getAccessor().getInstanceOf(CommandService.class);
    }

    public SCommandBuilderAccessor buildSCommandBuilderAccessor() {
        return getAccessor().getInstanceOf(SCommandBuilderAccessor.class);
    }

    public DependencyBuilderAccessor buildPlatformDependencyBuilderAccessor() {
        return getAccessor().getInstanceOf("platformDependencyBuilderAccessor", DependencyBuilderAccessor.class);
    }

    public PlatformCommandService buildPlatformCommandService() {
        return getAccessor().getInstanceOf(PlatformCommandService.class);
    }

    public SPlatformCommandBuilderAccessor buildSPlatformCommandBuilderAccessor() {
        return getAccessor().getInstanceOf(SPlatformCommandBuilderAccessor.class);
    }

    public ProfileService buildProfileService() {
        return getAccessor().getInstanceOf(ProfileService.class);
    }

    public Parser getParser() {
        return getAccessor().getInstanceOf(Parser.class);
    }

    public WorkService buildWorkService() {
        return getAccessor().getInstanceOf(WorkService.class);
    }

    public <T> T getInstanceOf(final Class<T> class1) {
        return getAccessor().getInstanceOf(class1);
    }

}
