#import <Foundation/Foundation.h>

@interface com_pmovil_nativega_impl_ScreenViewBuilderInterfaceImpl : NSObject {
}

-(void)set:(NSString*)param param1:(NSString*)param1;
-(NSString*)build;
-(void)setNonInteraction:(BOOL)param;
-(void)setCustomMetric:(int)param param1:(float)param1;
-(void)setNewSession;
-(void)setCustomDimension:(int)param param1:(NSString*)param1;
-(void)setCampaignParamsFromUrl:(NSString*)param;
-(BOOL)isSupported;
@end
