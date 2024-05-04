package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_addrecentsearch extends GXProcedure
{
   public wwp_addrecentsearch( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_addrecentsearch.class ), "" );
   }

   public wwp_addrecentsearch( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> aP0 ,
                        String aP1 ,
                        short aP2 ,
                        short aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> aP0 ,
                             String aP1 ,
                             short aP2 ,
                             short aP3 )
   {
      wwp_addrecentsearch.this.AV20WWP_SearchResults = aP0;
      wwp_addrecentsearch.this.AV18Url = aP1;
      wwp_addrecentsearch.this.AV11MaxCategories = aP2;
      wwp_addrecentsearch.this.AV12MaxItemsPerCategory = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      GXt_char1 = AV17RecentSearchResultsJson ;
      GXv_char2[0] = GXt_char1 ;
      new com.wwpbaseobjects.loaduserkeyvalue(remoteHandle, context).execute( "WWPRecentSearch", GXv_char2) ;
      wwp_addrecentsearch.this.GXt_char1 = GXv_char2[0] ;
      AV17RecentSearchResultsJson = GXt_char1 ;
      if ( (GXutil.strcmp("", AV17RecentSearchResultsJson)==0) )
      {
         AV14RecentSearches = new GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem>(com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem.class, "WWP_SearchResultsItem", "Gregory", remoteHandle) ;
      }
      else
      {
         AV14RecentSearches.fromJSonString(AV17RecentSearchResultsJson, null);
      }
      AV10Found = false ;
      AV22GXV1 = 1 ;
      while ( AV22GXV1 <= AV20WWP_SearchResults.size() )
      {
         AV21WWP_SearchResultsItem = (com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV20WWP_SearchResults.elementAt(-1+AV22GXV1));
         AV23GXV2 = 1 ;
         while ( AV23GXV2 <= AV21WWP_SearchResultsItem.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().size() )
         {
            AV19WWP_SearchResultItem = (com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)AV21WWP_SearchResultsItem.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().elementAt(-1+AV23GXV2));
            if ( GXutil.strcmp(AV19WWP_SearchResultItem.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url(), AV18Url) == 0 )
            {
               AV8CategoryFound = false ;
               AV24GXV3 = 1 ;
               while ( AV24GXV3 <= AV14RecentSearches.size() )
               {
                  AV16RecentSearchResults = (com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)AV14RecentSearches.elementAt(-1+AV24GXV3));
                  if ( GXutil.strcmp(AV16RecentSearchResults.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname(), AV21WWP_SearchResultsItem.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname()) == 0 )
                  {
                     AV8CategoryFound = true ;
                     AV9CurrentRecentSearchResults = AV16RecentSearchResults;
                     if (true) break;
                  }
                  AV24GXV3 = (int)(AV24GXV3+1) ;
               }
               AV13RecentAlreadyAdded = false ;
               if ( ! AV8CategoryFound )
               {
                  AV9CurrentRecentSearchResults = (com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)new com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem(remoteHandle, context);
                  AV9CurrentRecentSearchResults.setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname( AV21WWP_SearchResultsItem.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname() );
                  AV9CurrentRecentSearchResults.setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon( AV21WWP_SearchResultsItem.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon() );
                  AV9CurrentRecentSearchResults.setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Orderindex( AV21WWP_SearchResultsItem.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Orderindex() );
                  AV9CurrentRecentSearchResults.setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults( true );
                  AV14RecentSearches.add(AV9CurrentRecentSearchResults, 0);
                  if ( AV14RecentSearches.size() > AV11MaxCategories )
                  {
                     AV14RecentSearches.removeItem(1);
                  }
               }
               else
               {
                  AV25GXV4 = 1 ;
                  while ( AV25GXV4 <= AV9CurrentRecentSearchResults.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().size() )
                  {
                     AV15RecentSearchResultItem = (com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)((com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)AV9CurrentRecentSearchResults.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().elementAt(-1+AV25GXV4));
                     if ( GXutil.strcmp(AV15RecentSearchResultItem.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url(), AV18Url) == 0 )
                     {
                        AV13RecentAlreadyAdded = true ;
                        if (true) break;
                     }
                     AV25GXV4 = (int)(AV25GXV4+1) ;
                  }
               }
               if ( ! AV13RecentAlreadyAdded )
               {
                  AV9CurrentRecentSearchResults.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().add(AV19WWP_SearchResultItem.Clone(), 1);
                  if ( AV9CurrentRecentSearchResults.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().size() > AV12MaxItemsPerCategory )
                  {
                     AV9CurrentRecentSearchResults.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().removeItem(AV9CurrentRecentSearchResults.getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().size());
                  }
                  new com.wwpbaseobjects.saveuserkeyvalue(remoteHandle, context).execute( "WWPRecentSearch", AV14RecentSearches.toJSonString(false)) ;
               }
               AV10Found = true ;
               if (true) break;
            }
            AV23GXV2 = (int)(AV23GXV2+1) ;
         }
         if ( AV10Found )
         {
            if (true) break;
         }
         AV22GXV1 = (int)(AV22GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17RecentSearchResultsJson = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV14RecentSearches = new GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem>(com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem.class, "WWP_SearchResultsItem", "Gregory", remoteHandle);
      AV21WWP_SearchResultsItem = new com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem(remoteHandle, context);
      AV19WWP_SearchResultItem = new com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem(remoteHandle, context);
      AV16RecentSearchResults = new com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem(remoteHandle, context);
      AV9CurrentRecentSearchResults = new com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem(remoteHandle, context);
      AV15RecentSearchResultItem = new com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem(remoteHandle, context);
      /* GeneXus formulas. */
   }

   private short AV11MaxCategories ;
   private short AV12MaxItemsPerCategory ;
   private int AV22GXV1 ;
   private int AV23GXV2 ;
   private int AV24GXV3 ;
   private int AV25GXV4 ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean AV10Found ;
   private boolean AV8CategoryFound ;
   private boolean AV13RecentAlreadyAdded ;
   private String AV18Url ;
   private String AV17RecentSearchResultsJson ;
   private GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> AV20WWP_SearchResults ;
   private GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem> AV14RecentSearches ;
   private com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem AV21WWP_SearchResultsItem ;
   private com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem AV16RecentSearchResults ;
   private com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem AV9CurrentRecentSearchResults ;
   private com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem AV19WWP_SearchResultItem ;
   private com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem AV15RecentSearchResultItem ;
}

