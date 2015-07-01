#import "com_pmovil_nativega_impl_TrackerNativeInterfaceImpl.h"

@implementation com_pmovil_nativega_impl_TrackerNativeInterfaceImpl

-(NSString*)get:(NSString*)param{
    return [self->tracker get:param];
}

-(void)set:(NSString*)key value:(NSString*)value{
    [self->tracker set:key value:value];
}

-(void)initialize:(NSString*)param{
    self->tracker = [[GAI sharedInstance] trackerWithTrackingId:param];
}

-(void)setAppInstallerId:(NSString*)param{
    [self->tracker set:kGAIAppInstallerId value:param];
}

-(void)setLocation:(NSString*)param{
    [self->tracker set:kGAILocation value:param];
}

-(void)setTitle:(NSString*)param{
    [self->tracker set:kGAITitle value:param];
}

-(void)setEncoding:(NSString*)param{
    [self->tracker set:kGAIEncoding value:param];
}

-(void)send:(NSString*)param{
    NSError *jsonError;
    NSLog(@"Received json: %@", param);    
    NSData *objectData = [param dataUsingEncoding:NSUTF8StringEncoding];
    NSDictionary *json = [NSJSONSerialization JSONObjectWithData:objectData options:NSJSONReadingMutableContainers error:&jsonError];
    [self->tracker send:json];
}

-(void)setPage:(NSString*)param{
    [self->tracker set:kGAIPage value:param];
}

-(void)setAnonymizeIp:(BOOL)param{
    if(param){
        [self->tracker set:kGAIAnonymizeIp value:@"1"];
    } else {
        [self->tracker set:kGAIAnonymizeIp value:@"0"];
    }
}

-(void)setScreenName:(NSString*)param{
    [self->tracker set:kGAIScreenName value:param];
}

-(void)setScreenResolution:(int)x y:(int)y{
    NSString *param = [NSString stringWithFormat:@"%dx%d", x, y];
    [self->tracker set:kGAIScreenResolution value:param];
}

-(void)setSampleRate:(double)param{
    [self->tracker set:kGAISampleRate value:[@(param) stringValue]];
}

-(void)setScreenColors:(NSString*)param{
    [self->tracker set:kGAIScreenColors value:param];
}

-(void)setViewportSize:(NSString*)param{
    [self->tracker set:kGAIViewportSize value:param];
}

-(void)setCampaignParamsOnNextHit:(NSString*)param{
    //TODO: find where this can be set
}

-(void)enableExceptionReporting:(BOOL)param{
    //TODO: find where this can be set
}

-(void)setClientId:(NSString*)param{
    [self->tracker set:kGAIClientId value:param];
}

-(void)enableAdvertisingIdCollection:(BOOL)param{
    //TODO: find where this can be set
}

-(void)setSessionTimeout:(long long)param{
    //TODO: find where this can be set
}

-(void)setUseSecure:(BOOL)param{
    if(param){
        [self->tracker set:kGAIUseSecure value:@"1"];
    } else {
        [self->tracker set:kGAIUseSecure value:@"0"];
    }
}

-(void)setAppVersion:(NSString*)param{
    [self->tracker set:kGAIAppVersion value:param];
}

-(void)setHostname:(NSString*)param{
    [self->tracker set:kGAIHostname value:param];
}

-(void)setReferrer:(NSString*)param{
    [self->tracker set:kGAIReferrer value:param];
}

-(void)setAppId:(NSString*)param{
    [self->tracker set:kGAIAppId value:param];
}

-(void)enableAutoActivityTracking:(BOOL)param{
}

-(void)setAppName:(NSString*)param{
    [self->tracker set:kGAIAppName value:param];
}

-(void)setLanguage:(NSString*)param{
    [self->tracker set:kGAILanguage value:param];
}

-(BOOL)isSupported{
    return YES;
}

@end
