package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "wwpbaseobjects.menuitemloaddvcombo_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class menuitemloaddvcombo_RESTInterfaceIN
{
   String AV16ComboName;
   @JsonProperty("ComboName")
   public String getComboName( )
   {
      if ( GXutil.strcmp(AV16ComboName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV16ComboName ;
      }
   }

   @JsonProperty("ComboName")
   public void setComboName(  String Value )
   {
      if ( Value == null )
      {
         AV16ComboName = "" ;
      }
      else
      {
         AV16ComboName= Value;
      }
   }


   String AV17TrnMode;
   @JsonProperty("TrnMode")
   public String getTrnMode( )
   {
      if ( GXutil.strcmp(AV17TrnMode, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV17TrnMode ;
      }
   }

   @JsonProperty("TrnMode")
   public void setTrnMode(  String Value )
   {
      if ( Value == null )
      {
         AV17TrnMode = "" ;
      }
      else
      {
         AV17TrnMode= Value;
      }
   }


   boolean AV18IsDynamicCall;
   @JsonProperty("IsDynamicCall")
   public boolean getIsDynamicCall( )
   {
      return AV18IsDynamicCall ;
   }

   @JsonProperty("IsDynamicCall")
   public void setIsDynamicCall(  boolean Value )
   {
      AV18IsDynamicCall= Value;
   }


   short AV19MenuItemId;
   @JsonProperty("MenuItemId")
   public short getMenuItemId( )
   {
      return AV19MenuItemId ;
   }

   @JsonProperty("MenuItemId")
   public void setMenuItemId(  short Value )
   {
      AV19MenuItemId= Value;
   }


   String AV20SearchTxtParms;
   @JsonProperty("SearchTxtParms")
   public String getSearchTxtParms( )
   {
      if ( GXutil.strcmp(AV20SearchTxtParms, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV20SearchTxtParms ;
      }
   }

   @JsonProperty("SearchTxtParms")
   public void setSearchTxtParms(  String Value )
   {
      if ( Value == null )
      {
         AV20SearchTxtParms = "" ;
      }
      else
      {
         AV20SearchTxtParms= Value;
      }
   }


}

