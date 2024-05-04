package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.menuitemappmenuww", "/com.wwpbaseobjects.menuitemappmenuww"})
public final  class menuitemappmenuww extends GXWebPanelStub
{
   public menuitemappmenuww( )
   {
   }

   public menuitemappmenuww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( menuitemappmenuww.class ));
   }

   public menuitemappmenuww( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new menuitemappmenuww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new menuitemappmenuww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Application Menus";
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

