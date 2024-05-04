package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.wwp_downloadreport", "/com.wwpbaseobjects.wwp_downloadreport"})
public final  class wwp_downloadreport extends GXWebObjectStub
{
   public wwp_downloadreport( )
   {
   }

   public wwp_downloadreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_downloadreport.class ));
   }

   public wwp_downloadreport( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_downloadreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_downloadreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Download Report";
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

