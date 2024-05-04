package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.wwp_masterpagetopactionswc", "/com.wwpbaseobjects.wwp_masterpagetopactionswc"})
public final  class wwp_masterpagetopactionswc extends GXWebPanelStub
{
   public wwp_masterpagetopactionswc( )
   {
   }

   public wwp_masterpagetopactionswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_masterpagetopactionswc.class ));
   }

   public wwp_masterpagetopactionswc( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_masterpagetopactionswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_masterpagetopactionswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_Master Page Top Actions WC";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

