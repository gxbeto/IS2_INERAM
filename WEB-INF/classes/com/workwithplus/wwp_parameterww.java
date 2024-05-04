package com.workwithplus ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.workwithplus.wwp_parameterww", "/com.workwithplus.wwp_parameterww"})
public final  class wwp_parameterww extends GXWebPanelStub
{
   public wwp_parameterww( )
   {
   }

   public wwp_parameterww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_parameterww.class ));
   }

   public wwp_parameterww( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_parameterww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_parameterww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Parámetro";
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

