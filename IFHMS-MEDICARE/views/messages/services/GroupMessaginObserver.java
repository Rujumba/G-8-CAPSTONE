package views.messages.services;

import models.message.Message;

// Interface for observing group messages and notifying group members
/**
 * GroupMessaginObserver
 */
public interface GroupMessaginObserver {

     public void onMessageReceived(Message message);
    public void onMessageUpdated(Message message);
}