package uk.co.cacoethes.lazybones.api

/**
 * TODO What should happen if the target directory exists? What if it's empty?
 * What if it only has files that aren't in the template?
 */
interface LazybonesService {
    /**
     * Will throw an exception if another package source with the same name
     * has already been registered.
     * @param repository
     * @return
     */
    PackageSource registerPackageSource(PackageSource repository)
    Map<PackageSource, List<String>> listTemplates()
    List<CachedPackage> listCachedTemplates()
    List<PackageInfo> findPackages(String namePattern)

    /**
     * What's the behaviour if multiple package sources host a package with the
     * given name?
     * @param name
     * @return
     */
    PackageInfo getPackageInfo(String name)
    NewProjectInfo installTemplate(String name, String version, String targetPath, List<String> tmplQualifiers, Map model)
    NewProjectInfo installTemplate(URI packageUrl, String targetPath, List<String> tmplQualifiers, Map model)

    boolean isLazybonesProjectDir(File dir)
    List<String> listSubtemplates()
}