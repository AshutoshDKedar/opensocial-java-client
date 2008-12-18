/* Copyright (c) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import org.opensocial.data.OpenSocialPerson;
import org.opensocial.client.OpenSocialClient;

import java.util.Collection;

public class DisplayFriends {

  public static void main(String[] args) {
    OpenSocialClient c = new OpenSocialClient("orkut.com");

    // orkut supports both the REST and RPC protocols; RPC is preferred because
    // RPC supports batch requests
    c.setProperty(OpenSocialClient.Properties.RPC_ENDPOINT,
        "http://sandbox.orkut.com/social/rpc");
    
    // Credentials provided here are associated with the gadget located at
    // http://opensocial-resources.googlecode.com/svn/samples/rest_rpc/sample.xml;
    // If you install this gadget, you can substitute your own OpenSocial ID
    // for the one used below and fetch your profile data and friends
    c.setProperty(OpenSocialClient.Properties.CONSUMER_SECRET,
        "uynAeXiWTisflWX99KU1D2q5");
    c.setProperty(OpenSocialClient.Properties.CONSUMER_KEY,
        "orkut.com:623061448914");
    c.setProperty(OpenSocialClient.Properties.VIEWER_ID,
        "03067092798963641994");

    try {
      // Retrieve the friends of the specified user using the OpenSocialClient
      // method fetchFriends
      Collection<OpenSocialPerson> friends =
        c.fetchFriends("03067092798963641994");
      
      System.out.println("----------");
      
      // The fetchFriends method returns a typical Java Collection object with
      // all of the methods you're already accustomed to like size()
      System.out.println(friends.size() + " friends:");

      // Iterate through the Collection
      for (OpenSocialPerson friend : friends) {
        // Output the name of the current friend
        System.out.println("- " + friend.getDisplayName());
      }

      System.out.println("----------");

    } catch (Exception e) {}
  }

}