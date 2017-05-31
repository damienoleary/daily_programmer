package com.damienoleary;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<IPV4Network> networks = new LinkedList<>();
        Scanner sc = new Scanner(System.in, "utf-8");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            networks.add(IPV4Network.createNew(sc.next()));
        }

        Collections.sort(networks, new IPV4NetworkComparator());

        System.out.println("\n\nResults:");

        List<IPV4Network> toRemove = new ArrayList<>();

        while (!networks.isEmpty()) {
            IPV4Network network = networks.get(0);
            toRemove.add(network);
            for (int i = 1; i < networks.size(); i++) {
                IPV4Network candidate = networks.get(i);
                IPV4Network superNet = candidate.superNet(network.mask);
                if (superNet.ip == network.ip) {
                    toRemove.add(candidate);
                }
            }
            System.out.println(network);
            networks.removeAll(toRemove);
            toRemove.clear();
        }
    }
}
