package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_getappliedfiltersdescription extends GXProcedure
{
   public wwp_getappliedfiltersdescription( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_getappliedfiltersdescription.class ), "" );
   }

   public wwp_getappliedfiltersdescription( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      wwp_getappliedfiltersdescription.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      wwp_getappliedfiltersdescription.this.AV14ListObjectName = aP0;
      wwp_getappliedfiltersdescription.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      AV12GridState.fromxml(AV15Session.getValue(AV14ListObjectName+"GridState"), null, null);
      AV9index = (short)(1) ;
      while ( AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() >= AV9index )
      {
         if ( (GXutil.strcmp("", GXutil.trim( ((com.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV9index)).getgxTv_SdtWWPGridState_FilterValue_Dsc()))==0) )
         {
            AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().removeItem(AV9index);
         }
         else
         {
            AV9index = (short)(AV9index+1) ;
         }
      }
      AV16TotalFilters = (short)(AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size()+AV12GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size()) ;
      AV8AppliedFiltersDescription = "" ;
      if ( AV16TotalFilters > 0 )
      {
         AV17EmptyDateStr = GXutil.trim( localUtil.format( AV18AuxDate, "99/99/99")) ;
         AV19EmptyTimeStr = localUtil.format( AV20AuxDateTime, "99/99/99 99:99") ;
         AV19EmptyTimeStr = GXutil.trim( GXutil.strReplace( AV19EmptyTimeStr, AV17EmptyDateStr, "")) ;
         AV9index = (short)(1) ;
         AV21GXV1 = 1 ;
         while ( AV21GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
         {
            AV13GridStateFilterValue = (com.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV21GXV1));
            AV11FilterDescription = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Dsc() ;
            AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Valuedsc( GXutil.strReplace( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valuedsc(), AV19EmptyTimeStr, "") );
            AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Valuetodsc( GXutil.strReplace( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valuetodsc(), AV19EmptyTimeStr, "") );
            if ( ! (GXutil.strcmp("", AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valuedsc())==0) && ! (GXutil.strcmp("", AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valuetodsc())==0) )
            {
               AV11FilterDescription += GXutil.format( " (%1 - %2)", AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valuedsc(), AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valuetodsc(), "", "", "", "", "", "", "") ;
            }
            else if ( ! (GXutil.strcmp("", AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valuedsc())==0) )
            {
               AV11FilterDescription += GXutil.format( " (%1)", AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valuedsc(), "", "", "", "", "", "", "", "") ;
            }
            else if ( ! (GXutil.strcmp("", AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valuetodsc())==0) )
            {
               AV11FilterDescription += GXutil.format( " (%1)", AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valuetodsc(), "", "", "", "", "", "", "", "") ;
            }
            /* Execute user subroutine: 'ADD FILTER TO DESCRIPTION' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV21GXV1 = (int)(AV21GXV1+1) ;
         }
         AV22GXV2 = 1 ;
         while ( AV22GXV2 <= AV12GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() )
         {
            AV10DynamicFiltersItem = (com.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((com.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV12GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+AV22GXV2));
            AV11FilterDescription = AV10DynamicFiltersItem.getgxTv_SdtWWPGridState_DynamicFilter_Dsc() ;
            AV10DynamicFiltersItem.setgxTv_SdtWWPGridState_DynamicFilter_Valuedsc( GXutil.strReplace( AV10DynamicFiltersItem.getgxTv_SdtWWPGridState_DynamicFilter_Valuedsc(), AV19EmptyTimeStr, "") );
            AV10DynamicFiltersItem.setgxTv_SdtWWPGridState_DynamicFilter_Valuetodsc( GXutil.strReplace( AV10DynamicFiltersItem.getgxTv_SdtWWPGridState_DynamicFilter_Valuetodsc(), AV19EmptyTimeStr, "") );
            if ( ! (GXutil.strcmp("", AV10DynamicFiltersItem.getgxTv_SdtWWPGridState_DynamicFilter_Valuedsc())==0) && ! (GXutil.strcmp("", AV10DynamicFiltersItem.getgxTv_SdtWWPGridState_DynamicFilter_Valuetodsc())==0) )
            {
               AV11FilterDescription += GXutil.format( " (%1 - %2)", AV10DynamicFiltersItem.getgxTv_SdtWWPGridState_DynamicFilter_Valuedsc(), AV10DynamicFiltersItem.getgxTv_SdtWWPGridState_DynamicFilter_Valuetodsc(), "", "", "", "", "", "", "") ;
            }
            else if ( ! (GXutil.strcmp("", AV10DynamicFiltersItem.getgxTv_SdtWWPGridState_DynamicFilter_Valuedsc())==0) )
            {
               AV11FilterDescription += GXutil.format( " (%1)", AV10DynamicFiltersItem.getgxTv_SdtWWPGridState_DynamicFilter_Valuedsc(), "", "", "", "", "", "", "", "") ;
            }
            else if ( ! (GXutil.strcmp("", AV10DynamicFiltersItem.getgxTv_SdtWWPGridState_DynamicFilter_Valuetodsc())==0) )
            {
               AV11FilterDescription += GXutil.format( " (%1)", AV10DynamicFiltersItem.getgxTv_SdtWWPGridState_DynamicFilter_Valuetodsc(), "", "", "", "", "", "", "", "") ;
            }
            /* Execute user subroutine: 'ADD FILTER TO DESCRIPTION' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV22GXV2 = (int)(AV22GXV2+1) ;
         }
         AV8AppliedFiltersDescription = GXutil.format( "Filtrando por %1", AV8AppliedFiltersDescription, "", "", "", "", "", "", "", "") ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ADD FILTER TO DESCRIPTION' Routine */
      returnInSub = false ;
      if ( AV9index >= 6 )
      {
         if ( AV9index == 6 )
         {
            AV8AppliedFiltersDescription += "..." ;
         }
      }
      else
      {
         if ( AV9index > 1 )
         {
            AV8AppliedFiltersDescription += ((AV9index==AV16TotalFilters) ? " "+"y" : ",") + " " ;
         }
         AV8AppliedFiltersDescription += AV11FilterDescription ;
      }
      AV9index = (short)(AV9index+1) ;
   }

   protected void cleanup( )
   {
      this.aP1[0] = wwp_getappliedfiltersdescription.this.AV8AppliedFiltersDescription;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8AppliedFiltersDescription = "" ;
      AV12GridState = new com.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV15Session = httpContext.getWebSession();
      AV17EmptyDateStr = "" ;
      AV18AuxDate = GXutil.nullDate() ;
      AV19EmptyTimeStr = "" ;
      AV20AuxDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV13GridStateFilterValue = new com.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV11FilterDescription = "" ;
      AV10DynamicFiltersItem = new com.wwpbaseobjects.SdtWWPGridState_DynamicFilter(remoteHandle, context);
      /* GeneXus formulas. */
   }

   private short AV9index ;
   private short AV16TotalFilters ;
   private int AV21GXV1 ;
   private int AV22GXV2 ;
   private java.util.Date AV20AuxDateTime ;
   private java.util.Date AV18AuxDate ;
   private boolean returnInSub ;
   private String AV14ListObjectName ;
   private String AV8AppliedFiltersDescription ;
   private String AV17EmptyDateStr ;
   private String AV19EmptyTimeStr ;
   private String AV11FilterDescription ;
   private com.genexus.webpanels.WebSession AV15Session ;
   private String[] aP1 ;
   private com.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private com.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private com.wwpbaseobjects.SdtWWPGridState_DynamicFilter AV10DynamicFiltersItem ;
}

