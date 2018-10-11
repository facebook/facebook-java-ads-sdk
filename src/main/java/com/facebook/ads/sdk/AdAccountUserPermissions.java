/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.facebook.ads.sdk.APIException.MalformedResponseException;

/**
 * This class is auto-generated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class AdAccountUserPermissions extends APINode {
  @SerializedName("business")
  private Business mBusiness = null;
  @SerializedName("business_persona")
  private Object mBusinessPersona = null;
  @SerializedName("created_by")
  private User mCreatedBy = null;
  @SerializedName("created_time")
  private String mCreatedTime = null;
  @SerializedName("email")
  private String mEmail = null;
  @SerializedName("status")
  private String mStatus = null;
  @SerializedName("tasks")
  private List<String> mTasks = null;
  @SerializedName("updated_by")
  private User mUpdatedBy = null;
  @SerializedName("updated_time")
  private String mUpdatedTime = null;
  @SerializedName("user")
  private User mUser = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdAccountUserPermissions() {
  }

  public AdAccountUserPermissions(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdAccountUserPermissions(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdAccountUserPermissions fetch() throws APIException{
    AdAccountUserPermissions newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdAccountUserPermissions fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdAccountUserPermissions> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdAccountUserPermissions fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdAccountUserPermissions> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdAccountUserPermissions> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdAccountUserPermissions>)(
      new APIRequest<AdAccountUserPermissions>(context, "", "/", "GET", AdAccountUserPermissions.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdAccountUserPermissions>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdAccountUserPermissions.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdAccountUserPermissions loadJSON(String json, APIContext context) {
    AdAccountUserPermissions adAccountUserPermissions = getGson().fromJson(json, AdAccountUserPermissions.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountUserPermissions.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAccountUserPermissions.context = context;
    adAccountUserPermissions.rawValue = json;
    return adAccountUserPermissions;
  }

  public static APINodeList<AdAccountUserPermissions> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdAccountUserPermissions> adAccountUserPermissionss = new APINodeList<AdAccountUserPermissions>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    Exception exception = null;
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adAccountUserPermissionss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adAccountUserPermissionss;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountUserPermissionss.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountUserPermissionss.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountUserPermissionss.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountUserPermissionss.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  adAccountUserPermissionss.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountUserPermissionss.add(loadJSON(obj.toString(), context));
            }
          }
          return adAccountUserPermissionss;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountUserPermissionss.add(loadJSON(entry.getValue().toString(), context));
          }
          return adAccountUserPermissionss;
        } else {
          // Fifth, check if it's an array of objects indexed by id
          boolean isIdIndexedArray = true;
          for (Map.Entry entry : obj.entrySet()) {
            String key = (String) entry.getKey();
            if (key.equals("__fb_trace_id__")) {
              continue;
            }
            JsonElement value = (JsonElement) entry.getValue();
            if (
              value != null &&
              value.isJsonObject() &&
              value.getAsJsonObject().has("id") &&
              value.getAsJsonObject().get("id") != null &&
              value.getAsJsonObject().get("id").getAsString().equals(key)
            ) {
              adAccountUserPermissionss.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountUserPermissionss;
          }

          // Sixth, check if it's pure JsonObject
          adAccountUserPermissionss.clear();
          adAccountUserPermissionss.add(loadJSON(json, context));
          return adAccountUserPermissionss;
        }
      }
    } catch (Exception e) {
      exception = e;
    }
    throw new MalformedResponseException(
      "Invalid response string: " + json,
      exception
    );
  }

  @Override
  public APIContext getContext() {
    return context;
  }

  @Override
  public void setContext(APIContext context) {
    this.context = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public Business getFieldBusiness() {
    if (mBusiness != null) {
      mBusiness.context = getContext();
    }
    return mBusiness;
  }

  public Object getFieldBusinessPersona() {
    return mBusinessPersona;
  }

  public User getFieldCreatedBy() {
    if (mCreatedBy != null) {
      mCreatedBy.context = getContext();
    }
    return mCreatedBy;
  }

  public String getFieldCreatedTime() {
    return mCreatedTime;
  }

  public String getFieldEmail() {
    return mEmail;
  }

  public String getFieldStatus() {
    return mStatus;
  }

  public List<String> getFieldTasks() {
    return mTasks;
  }

  public User getFieldUpdatedBy() {
    if (mUpdatedBy != null) {
      mUpdatedBy.context = getContext();
    }
    return mUpdatedBy;
  }

  public String getFieldUpdatedTime() {
    return mUpdatedTime;
  }

  public User getFieldUser() {
    if (mUser != null) {
      mUser.context = getContext();
    }
    return mUser;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdAccountUserPermissions> {

    AdAccountUserPermissions lastResponse = null;
    @Override
    public AdAccountUserPermissions getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "business",
      "business_persona",
      "created_by",
      "created_time",
      "email",
      "status",
      "tasks",
      "updated_by",
      "updated_time",
      "user",
      "id",
    };

    @Override
    public AdAccountUserPermissions parseResponse(String response) throws APIException {
      return AdAccountUserPermissions.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdAccountUserPermissions execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdAccountUserPermissions execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdAccountUserPermissions> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdAccountUserPermissions> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdAccountUserPermissions>() {
           public AdAccountUserPermissions apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestBusinessField () {
      return this.requestBusinessField(true);
    }
    public APIRequestGet requestBusinessField (boolean value) {
      this.requestField("business", value);
      return this;
    }
    public APIRequestGet requestBusinessPersonaField () {
      return this.requestBusinessPersonaField(true);
    }
    public APIRequestGet requestBusinessPersonaField (boolean value) {
      this.requestField("business_persona", value);
      return this;
    }
    public APIRequestGet requestCreatedByField () {
      return this.requestCreatedByField(true);
    }
    public APIRequestGet requestCreatedByField (boolean value) {
      this.requestField("created_by", value);
      return this;
    }
    public APIRequestGet requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGet requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGet requestEmailField () {
      return this.requestEmailField(true);
    }
    public APIRequestGet requestEmailField (boolean value) {
      this.requestField("email", value);
      return this;
    }
    public APIRequestGet requestStatusField () {
      return this.requestStatusField(true);
    }
    public APIRequestGet requestStatusField (boolean value) {
      this.requestField("status", value);
      return this;
    }
    public APIRequestGet requestTasksField () {
      return this.requestTasksField(true);
    }
    public APIRequestGet requestTasksField (boolean value) {
      this.requestField("tasks", value);
      return this;
    }
    public APIRequestGet requestUpdatedByField () {
      return this.requestUpdatedByField(true);
    }
    public APIRequestGet requestUpdatedByField (boolean value) {
      this.requestField("updated_by", value);
      return this;
    }
    public APIRequestGet requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGet requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGet requestUserField () {
      return this.requestUserField(true);
    }
    public APIRequestGet requestUserField (boolean value) {
      this.requestField("user", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }


  synchronized /*package*/ static Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.STATIC)
        .excludeFieldsWithModifiers(Modifier.PROTECTED)
        .disableHtmlEscaping()
        .create();
    }
    return gson;
  }

  public AdAccountUserPermissions copyFrom(AdAccountUserPermissions instance) {
    this.mBusiness = instance.mBusiness;
    this.mBusinessPersona = instance.mBusinessPersona;
    this.mCreatedBy = instance.mCreatedBy;
    this.mCreatedTime = instance.mCreatedTime;
    this.mEmail = instance.mEmail;
    this.mStatus = instance.mStatus;
    this.mTasks = instance.mTasks;
    this.mUpdatedBy = instance.mUpdatedBy;
    this.mUpdatedTime = instance.mUpdatedTime;
    this.mUser = instance.mUser;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountUserPermissions> getParser() {
    return new APIRequest.ResponseParser<AdAccountUserPermissions>() {
      public APINodeList<AdAccountUserPermissions> parseResponse(String response, APIContext context, APIRequest<AdAccountUserPermissions> request) throws MalformedResponseException {
        return AdAccountUserPermissions.parseResponse(response, context, request);
      }
    };
  }
}
