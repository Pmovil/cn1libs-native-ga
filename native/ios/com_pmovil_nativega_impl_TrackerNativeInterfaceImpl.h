#import <Foundation/Foundation.h>
#import "GAI.h"
#import "GAITracker.h"
#import "GAIFields.h"


@interface com_pmovil_nativega_impl_TrackerNativeInterfaceImpl : NSObject {
    @private id<GAITracker> tracker;
}

-(NSString*)get:(NSString*)param;
-(void)set:(NSString*)key value:(NSString*)value;
-(void)initialize:(NSString*)param;
-(void)setAppInstallerId:(NSString*)param;
-(void)setLocation:(NSString*)param;
-(void)setTitle:(NSString*)param;
-(void)setEncoding:(NSString*)param;
-(void)send:(NSString*)param;
-(void)setPage:(NSString*)param;
-(void)setAnonymizeIp:(BOOL)param;
-(void)setScreenName:(NSString*)param;
-(void)setScreenResolution:(int)x y:(int)y;
-(void)setSampleRate:(double)param;
-(void)setScreenColors:(NSString*)param;
-(void)setViewportSize:(NSString*)param;
-(void)setCampaignParamsOnNextHit:(NSString*)param;
-(void)enableExceptionReporting:(BOOL)param;
-(void)setClientId:(NSString*)param;
-(void)enableAdvertisingIdCollection:(BOOL)param;
-(void)setSessionTimeout:(long long)param;
-(void)setUseSecure:(BOOL)param;
-(void)setAppVersion:(NSString*)param;
-(void)setHostname:(NSString*)param;
-(void)setReferrer:(NSString*)param;
-(void)setAppId:(NSString*)param;
-(void)enableAutoActivityTracking:(BOOL)param;
-(void)setAppName:(NSString*)param;
-(void)setLanguage:(NSString*)param;
-(BOOL)isSupported;
@end
