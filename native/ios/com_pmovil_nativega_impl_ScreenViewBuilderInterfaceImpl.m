#import "com_pmovil_nativega_impl_ScreenViewBuilderInterfaceImpl.h"

@implementation com_pmovil_nativega_impl_ScreenViewBuilderInterfaceImpl


- (id)init {
    self = [super init];
    if (self) {
        self->builder = [GAIDictionaryBuilder createScreenView];
    }
    return self;

}


-(void)set:(NSString*)key value:(NSString*)value{
    [self->builder setValue:key forKey:value];
}

-(NSString*)build{
    NSError *error;
    NSData *jsonData = [NSJSONSerialization dataWithJSONObject:[self->builder build]  options:(NSJSONWritingOptions) (0) error:&error];
    NSString *result = [[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding];
    NSLog(@"Returning json: %@", result);
    return result;
}

-(void)setNonInteraction:(BOOL)param{
    //TODO: discover wath it means/if it is appliclable}
}

-(void)setCustomMetric:(int)param param1:(float)param1{
    //TODO: discover wath it means/if it is appliclable
}

-(void)setNewSession{
    self->builder = [GAIDictionaryBuilder createScreenView];
}

-(void)setCustomDimension:(int)param param1:(NSString*)param1{
    //TODO: discover wath it means/if it is appliclable
}

-(void)setCampaignParamsFromUrl:(NSString*)param{
    [self->builder setCampaignParametersFromUrl:param];
}

-(BOOL)isSupported{
    return YES;
}

@end
