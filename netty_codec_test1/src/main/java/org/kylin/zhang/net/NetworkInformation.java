package org.kylin.zhang.net;

/**
 * Created by root on 7/5/15.
 *
 * This class is used to contain all perinet information about a
 * linked P2PNetwork.
 *
 */
public class NetworkInformation {
    private final String name;

    private final short maxConnectedPeers;

    private int connectedPeers;

    private boolean acceptingConnections;

    public NetworkInformation(String name, short maxPeers) {
        this.name = name;
        this.maxConnectedPeers = maxPeers;
        this.acceptingConnections = true;

        connectedPeers = 0;
    }

    void setAcceptingConnections(boolean value) {
        acceptingConnections = value;
    }

    void addPeer() {
        connectedPeers++;
    }

    void addPeer(int number) {
        connectedPeers += number;
    }

    public boolean isAcceptingConnections() {
        return acceptingConnections;
    }

    /**
     * @return The name associated with this network
     */
    public String getName() {
        return name;
    }

    /**
     * @return The maximum number of peers accepted by this network
     */
    public int getMaxConnectedPeers() {
        return maxConnectedPeers;
    }

    /**
     * @return the number of currently connected peers
     */
    public int getConnectedPeers() {
        return connectedPeers;
    }

    /**
     * method used to check if it is possible to connect to this
     * network with the right password
     *
     * @return if this network is accepting connections and
     * that the connected peers do not exceed the maximum limition
     */
    public boolean isOpen() {
        return acceptingConnections && connectedPeers < this.maxConnectedPeers;
    }

}
