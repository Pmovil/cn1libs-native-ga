#import "com_pmovil_nativega_impl_GANativeInterfaceImpl.h"


@implementation com_pmovil_nativega_impl_GANativeInterfaceImpl

-(void)setDryRun:(BOOL)param{
    [[GAI sharedInstance]setDryRun:param];
}

-(BOOL)isDryRunEnabled{
    return [[GAI sharedInstance]dryRun];
}

-(void)setAppOptOut:(BOOL)param{
    [[GAI sharedInstance] setOptOut:param];
}

-(void)dispatchLocalHits{
    [[GAI sharedInstance] dispatch];
}

-(void)setLocalDispatchPeriod:(int)param{
    [[GAI sharedInstance] setDispatchInterval:param];
}

-(BOOL)getAppOptOut{
    return [[GAI sharedInstance] optOut];
}

-(BOOL)isSupported{
    return YES;
}

@end
