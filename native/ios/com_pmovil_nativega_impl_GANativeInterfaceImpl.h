#import <Foundation/Foundation.h>
#import "GAI.h"

@interface com_pmovil_nativega_impl_GANativeInterfaceImpl : NSObject {
}

-(void)setDryRun:(BOOL)param;
-(BOOL)isDryRunEnabled;
-(void)setAppOptOut:(BOOL)param;
-(void)dispatchLocalHits;
-(void)setLocalDispatchPeriod:(int)param;
-(BOOL)getAppOptOut;
-(BOOL)isSupported;
@end
